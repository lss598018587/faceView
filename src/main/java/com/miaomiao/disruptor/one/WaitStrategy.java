package com.miaomiao.disruptor.one;

public interface WaitStrategy {
    /**
     * 消费者的阻塞方法
     * @param sequence
     * @param cursor
     */
    long waitFor(long sequence, Sequence cursor) throws InterruptedException;

    /**
     * 生成者，生成完，通知消费者的方法
     */
    void signalAllWhenBlocking();

}
