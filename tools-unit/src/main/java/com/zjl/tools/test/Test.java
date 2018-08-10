package com.zjl.tools.test;

import com.zjl.tools.MathTools;

public class Test {
	public static void main(String[] args) {
		double b = 3.23343;
		b = MathTools.round45BigDecimal(b,3);
		System.out.println(b);
	}
	
}
