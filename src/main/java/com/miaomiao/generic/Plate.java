package com.miaomiao.generic;

/**
 * @Auther: miaomiao
 * @Date: 2019-09-24 09:51
 * @Description:
 */
public class Plate<T > {
    private T item;

    public Plate(T item) {
        this.item = item;
    }

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }
}
