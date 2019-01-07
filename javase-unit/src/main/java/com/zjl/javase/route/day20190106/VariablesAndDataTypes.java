package com.zjl.javase.route.day20190106;

public class VariablesAndDataTypes {
		public static void main(String[] args) {
			int int10 = 23; //十进制
			int int8 = 012;//八进制
			System.out.println(int8);
			int int16 = 0XFF;
			System.out.println(int16);
			byte byte1 = -128; //1个字节    //-128至127
			System.out.println(Byte.MAX_VALUE);
			System.out.println(Byte.MIN_VALUE);
			short short1 = 4212;//2个字节
			System.out.println(Short.MAX_VALUE);
			System.out.println(Short.MIN_VALUE);
			int int1 = 2342; //4个字节
			System.out.println(Integer.MAX_VALUE);
			System.out.println(Integer.MIN_VALUE);
			long long1 = 3241255;//8个字节
			System.out.println(Long.MAX_VALUE);
			System.out.println(Long.MIN_VALUE);
			System.out.println(Long.MAX_VALUE+1);
			System.out.println(Long.MIN_VALUE-1);
			float float1 = 23.44f;
			System.out.println(Float.MAX_VALUE);
			System.out.println(Float.MIN_VALUE);
			double doubel1 = 24.44;
			double doubel2 = 1.33568E2;
			System.out.println(Double.MAX_VALUE);
			System.out.println(Double.MIN_VALUE);
			System.out.println(doubel2);
			boolean boolean1 = true;
			System.out.println(boolean1);
			char char1 = 'A';
			char char回车 = '\r';
			char char单引号 = '\'';
			char char反斜线 = '\\';
		}
}
