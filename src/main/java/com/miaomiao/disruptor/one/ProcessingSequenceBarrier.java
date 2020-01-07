package com.miaomiao.disruptor.one;

public class ProcessingSequenceBarrier  implements SequenceBarrier {
    /**
     * 生产者的最大索引
     */
    private final Sequence cursorSequence;
    //等待策略。
    private final WaitStrategy waitStrategy;
    /**
     * 消费者索引
     */
    private  Sequence gatingSequences[];

    public ProcessingSequenceBarrier(final Sequence cursorSequence,final WaitStrategy waitStrategy) {
        this.cursorSequence = cursorSequence;
        this.waitStrategy = waitStrategy;
    }

    @Override
    public long waitFor(long sequence) throws InterruptedException {

        return   waitStrategy.waitFor(sequence,cursorSequence);

    }

    @Override
    public long getCursor() {
        return cursorSequence.get();
    }


}
