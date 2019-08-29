package com.miaomiao.cpu;

/**
 * @Auther: miaomiao
 * @Date: 2019-08-29 19:16
 * @Description:
 *
 * 多个变量可能在一个cashLine，导致一个volatile变更的时候，其他线程要去cpu去更新所有的变量
 *
 *
 */
public class CashLine implements Runnable{
    public final static int NUM_THREADS = 4;
    public final static long ITERATIONS = 100L * 1000L * 1000L;
    private  int arrayIndex = 1;

    private static VolatileLong[] longs = new VolatileLong[NUM_THREADS];

    public CashLine(final int arrayIndex) {
        this.arrayIndex = arrayIndex;
    }

    static {
        for (int i = 0; i < longs.length; i++) {
            longs[i] = new VolatileLong();
        }
    }

    public static void main(String[] args) throws Exception{
        final long start = System.nanoTime();

        runTest();

        System.out.println("duration = " + (System.nanoTime() - start));


    }

    private static void runTest() throws InterruptedException {
        Thread[] threads = new Thread[NUM_THREADS];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(new CashLine(i));
        }

        for (Thread t : threads) {
            t.start();
        }
        for (Thread t : threads) {
            t.join();
        }
    }

    @Override
    public void run() {
        long i = ITERATIONS + 1;
        while (0 != --i) {
            longs[arrayIndex].value = i;
        }
    }

    public final static class VolatileLong {
        public long p0, p1, p2, p3, p4, p5;

        public volatile long value = 0L;

        public long q0, q1, q2, q3, q4, q5;

    }
}
