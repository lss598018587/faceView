package com.miaomiao.disruptor.one;

public interface EventHandler<T>
{
    void onEvent(T event, long sequence) throws Exception;
}

