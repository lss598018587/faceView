package com.miaomiao.disruptor.one;

public class BlockingWaitStrategy implements WaitStrategy {
    private final Object mutex = new Object();

    /**
     *
     * @param sequence  要消费的指针
     * @param cursorSequence  生产者的sequence
     */
    @Override
    public long waitFor(long sequence, Sequence cursorSequence) throws InterruptedException {
        long availableSequence;
        if (cursorSequence.get() < sequence)
        {
            synchronized (mutex)
            {
                while (cursorSequence.get() < sequence)
                {
                    mutex.wait();
                }
            }
        }
        availableSequence = cursorSequence.get();
        return availableSequence;
    }
    @Override
    public void signalAllWhenBlocking()
    {
        synchronized (mutex)
        {
            mutex.notifyAll();
        }
    }

}

