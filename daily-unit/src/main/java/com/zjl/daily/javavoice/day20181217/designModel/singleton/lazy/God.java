package com.zjl.daily.javavoice.day20181217.designModel.singleton.lazy;

public class God {
	private static God god;//这里不进行实例化
    private God(){}
    public static God getInstance() {
        if (god == null) {//如果无神才造神
            god = new God();
        }
        return god;
    }
}
