package com.miaomiao.vlo;

/**
 * @Auther: miaomiao
 * @Date: 2019-09-25 20:55
 * @Description:
 */
public class Test02 {
    static boolean flag = false;

    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程1开始了");
                try {
                    Thread.sleep(1000);
                }catch (Exception e){

                }
                flag=true;
                System.out.println("线程1结束了");
            }
        }, "线程1号");

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程2开始了");
                while(!flag){

                }
                System.out.println("线程结束了");
            }
        }, "线程2号");


        t1.start();
        t2.start();
//       for (;;){
//           Thread.sleep(500);
//           System.out.println(cc[0]);
//       }
    }

}
