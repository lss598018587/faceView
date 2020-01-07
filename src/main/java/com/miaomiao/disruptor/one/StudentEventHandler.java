package com.miaomiao.disruptor.one;

public class StudentEventHandler implements EventHandler<Student> {
    @Override
    public void onEvent(Student event, long sequence) throws Exception {
        System.out.println("我进行异步消费了："+event.getName());
    }
}
