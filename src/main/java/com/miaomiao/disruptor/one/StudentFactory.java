package com.miaomiao.disruptor.one;

public class StudentFactory implements EventFactory<Student> {
    @Override
    public Student newInstance() {
        return new Student();
    }
}
