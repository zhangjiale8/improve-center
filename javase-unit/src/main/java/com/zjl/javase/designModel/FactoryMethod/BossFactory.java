package com.zjl.javase.designModel.FactoryMethod;

import com.zjl.javase.designModel.FactoryMethod.common.Enemy;

public class BossFactory implements Factory {

    @Override
    public Enemy create(int screenWidth) {
        // boss应该出现在屏幕中央
        return new Boss(screenWidth / 2, 0);
    }

}