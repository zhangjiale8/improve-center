package com.zjl.tools;

import java.math.BigDecimal;

public class MathTools {
	/**
	 * 四舍五入
	 * BigDecimal 模式
	 * @param param 参数
	 * @param num 保留位数
	 * @return
	 */
	public static double round45BigDecimal(double param, int num) {
		BigDecimal bd = new BigDecimal(new Double(param));		
		return bd.setScale(num, BigDecimal.ROUND_HALF_UP).doubleValue();
	}

}
