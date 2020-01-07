package com.miaomiao.disruptor.one;

public class BatchEventProcessor<T> implements EventProcessor {
    /**
     * 消费者，消费到哪里的指针
     */
    private final Sequence sequence = new Sequence(-1L);
    /**
     * 存放的环形队列
     */
    private Object[] objects;

    private int ringBuffSize;

    private final SequenceBarrier sequenceBarrier;

    /**
     * 正真处理事件的回调接口。
     */
    private final EventHandler<? super T> eventHandler;

    public BatchEventProcessor(EventHandler<? super T> eventHandler,Object[] objects, int ringBuffSize,SequenceBarrier sequenceBarrier) {
        this.eventHandler = eventHandler;
        this.objects = objects;
        this.ringBuffSize = ringBuffSize;
        this.sequenceBarrier = sequenceBarrier;
    }

    @Override
    public void run() {
        long nextSequence = this.sequence.get() + 1L;

        try {
            while(true) {
                final long availableSequence = sequenceBarrier.waitFor(nextSequence);

                while(nextSequence<=availableSequence){
                    T t = (T)this.objects[(int)nextSequence%ringBuffSize];
                    eventHandler.onEvent(t, nextSequence);
                    nextSequence++;
                }
                //处理完毕后，设置当前处理完成的最后序列值。
                sequence.set(availableSequence);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Sequence getSequence() {
        return sequence;
    }
}
