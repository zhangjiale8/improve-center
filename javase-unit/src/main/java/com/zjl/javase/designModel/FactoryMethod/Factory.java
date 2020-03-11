package com.zjl.javase.designModel.FactoryMethod;

import com.zjl.javase.designModel.FactoryMethod.common.Enemy;

public interface Factory {

    public Enemy create(int screenWidth);

}
