package com.zjl.daily.javavoice.day20181217.designModel.iterator;

public interface Iterator<E> {
    E next();//返回下一个元素
    boolean hasNext();//是否还有下一个元素
}
