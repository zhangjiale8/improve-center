package com.zjl.daily.javavoice.day20181217.designModel.singleton.safethread;

public class God2 {
	 private volatile static God2 god;
	 private God2(){
		 
	 } 

	public static God2 getInstance() {// 庙是开放的不用排队进入
		if (god == null) {// 如果头柱香未产生，这批抢香人进入堂内排队。
			synchronized (God2.class) {
				if (god == null) {// 只有头香造了神，其他抢香的白排队了
					god = new God2();
				}
			}
		}
		// 此处头柱香产生后不必再排队
		return god;
	}
}
