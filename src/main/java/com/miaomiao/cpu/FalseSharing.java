package com.miaomiao.cpu;

/**
 * @Auther: miaomiao
 * @Date: 2019-09-20 16:56
 * @Description:
 */
public class FalseSharing  implements Runnable {

    public final static int NUM_THREADS = 4;
    public final static long ITERATIONS = 500L * 1000L * 1000L;
    private final int arrayIndex;

    private static VolatileLong[] longs = new VolatileLong[NUM_THREADS];
    static
    {
        for (int i = 0; i < longs.length; i++)
        {
            //VolatileLong 这里 是4个对象，因为每个对象只有一个long字段。
            //暂时声明四个对象昵称为 A、B、C、D
            //可能导致 A和B的字段在一个cashLine，或 ABDC在一个cashline都有可能
            longs[i] = new VolatileLong();
        }
    }

    public FalseSharing(final int arrayIndex)
    {
        this.arrayIndex = arrayIndex;
    }

    public static void main(final String[] args) throws Exception
    {
        final long start = System.nanoTime();
        runTest();
        System.out.println("duration = " + (System.nanoTime() - start));
    }

    private static void runTest() throws InterruptedException
    {
        Thread[] threads = new Thread[NUM_THREADS];

        for (int i = 0; i < threads.length; i++)
        {
            threads[i] = new Thread(new FalseSharing(i));
        }

        for (Thread t : threads)
        {
            t.start();
        }

        for (Thread t : threads)
        {
            t.join();
        }
    }

    @Override
    public void run()
    {
        long i = ITERATIONS + 1;
        while (0 != --i)
        {
            longs[arrayIndex].value = i;
        }
    }

    public final static class VolatileLong
    {
//        public long p1, p2, p3, p4, p5, p6,p7; // comment out
        public volatile long value = 0L;
//        public long p8, p9, p10, p11, p12, p13,p14; // comment out
    }
}
