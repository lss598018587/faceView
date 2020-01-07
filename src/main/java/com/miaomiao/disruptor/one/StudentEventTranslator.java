package com.miaomiao.disruptor.one;

public class StudentEventTranslator implements EventTranslatorOneArg<Student,Student>{
    @Override
    public void translateTo(Student event, long sequence, Student arg0) {
        event.setName(arg0.getName());
        event.setId(arg0.getId());
    }

}
