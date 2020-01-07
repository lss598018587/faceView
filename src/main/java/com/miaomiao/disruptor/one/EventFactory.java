package com.miaomiao.disruptor.one;

public interface EventFactory<T> {
    T newInstance();
}
