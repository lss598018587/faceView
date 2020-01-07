package com.miaomiao.disruptor.one;

public interface EventTranslatorOneArg<T, A> {
    void translateTo(T event, long sequence, A arg0);
}
