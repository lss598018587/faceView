package com.miaomiao.vlo;

/**
 * @Auther: miaomiao
 * @Date: 2019-09-25 14:52
 * @Description:
 */
public class ThreadPrintDemo {
    static int num = 0;


    public static void main(String[] args) throws InterruptedException {

        Student st = new Student();
        long startTime = System.currentTimeMillis();
        System.out.println(startTime);
//        Thread t1 = new Thread(() -> {
//             num=0;
//
//
//            for (; 10000 > num; ) {
//
//                    num++;
//                    System.out.println(System.currentTimeMillis()+"-"+Thread.currentThread().getName()+ num);
//            }
//        },"线程1号"
//        );
//
//        Thread t2 = new Thread(() -> {
//             num=0;
//            for (; 10 > num; ) {
//                    num++;
//                    System.out.println(System.currentTimeMillis()+"-"+Thread.currentThread().getName()+num);
//            }
//           try {
//               Thread.sleep(2000);
//           }catch (Exception e){
//
//           }
//        },"线程2号"
//        );

//        t1.start();
//        Thread.sleep(10);
//        t2.start();
        System.out.println(System.currentTimeMillis()-startTime);
    }

}
class Student{
    public volatile long flag = 0L;
    public long p1, p2, p3, p4, p5, p6;
}
