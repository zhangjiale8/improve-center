package com.zjl.daily.javavoice.day20181217.designModel.FactoryMethod;

import com.zjl.daily.javavoice.day20181217.designModel.FactoryMethod.common.Enemy;

public interface Factory {

    public Enemy create(int screenWidth);

}
