package com.miaomiao.disruptor.one;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.LockSupport;

public class DisMain<T> {
    /**
     * 存放的环形队列
     */
    private Object[] objects;

    /**
     * 尾部指针
     */
    private int tail;

    /**
     * 头部指针
     */
    private int head;

    /**
     * 环形大小
     */
    public int ringBuffSie;

    /**
     * 生产者的指针
     */
    private Sequence producer = new Sequence();
    /**
     * 等待策略
     */
    protected final WaitStrategy waitStrategy;
    /**
     * 消费者的消费指针
     */
    private Sequence[] processorSequences;
    /**
     * 消费者
     */
    private List<BatchEventProcessor> processorList;


    private ExecutorService executors = Executors.newCachedThreadPool();

    /**
     * 初始值
     */
    long nextValue = -1;
    long cachedValue = -1;

    /**
     * 传入消费的工厂
     *
     * @param eventHandlers
     */
    public final void handleEventsWith(final EventHandler<? super T>... eventHandlers) {
        int i = 0;
        final SequenceBarrier barrier = new ProcessingSequenceBarrier(producer, this.waitStrategy);
        processorSequences = new Sequence[eventHandlers.length];
        for (int eventHandlersLength = eventHandlers.length; i < eventHandlersLength; ++i) {
            EventHandler<? super T> eventHandler = eventHandlers[i];
            BatchEventProcessor<T> batchEventProcessor = new BatchEventProcessor(eventHandler, this.objects, ringBuffSie, barrier);
            if (this.processorList == null) {
                this.processorList = new ArrayList<>();
            }
            this.processorList.add(batchEventProcessor);
            //我这里是直接放在disMain里，disruptor是直接放在ringbuffer里
            processorSequences[i] = batchEventProcessor.getSequence();
        }
    }

    public void start() {
        for (BatchEventProcessor batchEventProcessor : processorList) {
            executors.execute(batchEventProcessor);
        }
    }


    public DisMain(int ringBuffSie, EventFactory eventFactory) {
        this(ringBuffSie,eventFactory,new BlockingWaitStrategy());

    }
    public DisMain(int ringBuffSie, EventFactory eventFactory,WaitStrategy waitStrategy) {
        this.waitStrategy = waitStrategy;
        this.ringBuffSie = ringBuffSie;
        objects = new Object[ringBuffSie];
        for (int i = 0; i < ringBuffSie; i++) {
            objects[i] = eventFactory.newInstance();
        }
    }

    /**
     * 判断环形是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        if (tail == head) {
            return true;
        }
        return false;
    }

    public boolean put(T obj) {
        if (isFull()) {
            return false;
        } else {
            objects[tail % ringBuffSie] = obj;
            tail++;
            return true;
        }
    }

    public <A> boolean put(EventTranslatorOneArg<T, A> arg, A arg0) {
        if (isFull()) {
            return false;
        } else {
            int position = tail % ringBuffSie;
            this.producer.set(tail);
            T t = (T) objects[position];
            arg.translateTo(t, tail, arg0);
            tail++;
            return true;
        }
    }

    public <A> boolean putNew(EventTranslatorOneArg<T, A> arg, A arg0) {
        long next = next();
        int position = (int) next % ringBuffSie;
        T t = (T) objects[position];
        arg.translateTo(t, next, arg0);
        publish(next);
        return true;
    }


    public T get() {
        if (isEmpty()) {
            return null;
        } else {
            Object obj = objects[head];
            head++;
            return (T) obj;
        }
    }

    /**
     * 判断环形是否填满
     *
     * @return
     */
    public boolean isFull() {
        //现在的位置
        int nowPro = tail - ringBuffSie;
        if ((nowPro + 1) == head) {
            return true;
        }
        return false;
    }




    public long next() {
        return next(1);
    }

    public long next(int n) {
        if (n < 1) {
            throw new IllegalArgumentException("n must be > 0");
        }

        //下一个生产Sequence位置
        long nextValue = this.nextValue;
        //next方法和之前的hasAvailableCapacity同理，只不过这里是相当于阻塞的
        long nextSequence = nextValue + n;
        //下一位置加上所需容量减去整个bufferSize，如果为正数，那证明至少转了一圈
        long wrapPoint = nextSequence - ringBuffSie;
        long cachedGatingSequence = this.cachedValue;

        if (wrapPoint > cachedGatingSequence || cachedGatingSequence > nextValue) {
            producer.set(nextValue);

            long minSequence;
            //只要wrapPoint大于最小的gatingSequences，那么不断唤醒消费者去消费，并利用LockSupport让出CPU，直到wrapPoint不大于最小的gatingSequences
            while (wrapPoint > (minSequence = getMinimumSequence(processorSequences, nextValue))) {
//               为了线程调度禁用当前线程，最多等待指定的等待时间，除非许可可用。
                LockSupport.parkNanos(1L);
            }
            //满足生产条件了，缓存这次消费者线程最小消费序号，供下次使用
            this.cachedValue = minSequence;
        }

        this.nextValue = nextSequence;

        return nextSequence;
    }

    private long getMinimumSequence(Sequence[] sequences, long minimum) {
        for (int i = 0, n = sequences.length; i < n; i++) {
            long value = sequences[i].get();
            minimum = Math.min(minimum, value);
        }

        return minimum;
    }

    public void publish(long sequence) {
        //cursor代表可以消费的sequence
        producer.set(sequence);
        waitStrategy.signalAllWhenBlocking();
    }

    public static void main( String[] args ) throws InterruptedException {

        DisMain<Student> disMain = new DisMain(16, new StudentFactory());
        StudentEventHandler studentEventHandler = new StudentEventHandler();
        disMain.handleEventsWith(studentEventHandler);


        disMain.start();

        EventTranslatorOneArg translator = new StudentEventTranslator();
        Student stu = new Student();
        for (int i = 0; i < 20; i++) {
            stu.setId(i);
            stu.setName("test" + i);
            disMain.putNew(translator, stu);
        }
        Thread.sleep(5000);
        for (int i = 20; i < 25; i++) {
            stu.setId(i);
            stu.setName("test" + i);
            disMain.putNew(translator, stu);
        }

    }
}
