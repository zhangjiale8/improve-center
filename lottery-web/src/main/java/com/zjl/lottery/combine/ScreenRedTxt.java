package com.zjl.lottery.combine;

import java.util.ArrayList;

public class ScreenRedTxt {
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(2);
		list.add(1);
		list.add(1);
		String temp = list.toString();
		temp = temp.substring(1, temp.length());
		temp = temp.substring(0, temp.length()-1);
		System.out.println(temp);
	}
}
