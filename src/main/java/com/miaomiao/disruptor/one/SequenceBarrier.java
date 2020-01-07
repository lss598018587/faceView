package com.miaomiao.disruptor.one;

public interface SequenceBarrier {
    /**
     * 等待一个序列变为可用，然后消费这个序列。.
     * 这货明显是给事件处理者使用的。
     */
    long waitFor(long sequence) throws InterruptedException;

    /**
     * 获取当前可以读取的序列值。
     */
    long getCursor();

}
