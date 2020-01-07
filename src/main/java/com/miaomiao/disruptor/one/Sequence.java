package com.miaomiao.disruptor.one;

public class Sequence {
    private   long value;


    public Sequence() {
        this(-1L);
    }

    public Sequence(long initialValue) {
        value=initialValue;
    }
    public long get() {
        return this.value;
    }
    public void set(long value) {
        this.value=value;
    }
}
