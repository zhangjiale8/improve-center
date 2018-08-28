package com.zjl.javase.time;

import java.util.Date;

import com.zjl.tools.TimeTools;

public class TimeT {
	public static void main(String[] args) {
		Date [] dateArr = new Date [5];
		dateArr[0] = TimeTools.DateFormate("2018-08-22 08:00:00", TimeTools.Y_M_D_H_M_S);
		dateArr[1] = TimeTools.DateFormate("2018-08-21 08:00:00", TimeTools.Y_M_D_H_M_S);
		dateArr[2] = TimeTools.DateFormate("2018-08-22 09:00:00", TimeTools.Y_M_D_H_M_S);
		dateArr[3] = TimeTools.DateFormate("2018-08-22 12:00:00", TimeTools.Y_M_D_H_M_S);
		dateArr[4] = TimeTools.DateFormate("2018-08-22 07:00:00", TimeTools.Y_M_D_H_M_S);
		Date param = TimeTools.DateFormate("2018-08-21 04:00:00", TimeTools.Y_M_D_H_M_S);
		Date date = TimeTools.getMinDistanceTime(dateArr,param);
		System.out.println(TimeTools.DateStr(date, TimeTools.Y_M_D_H_M_S));
	}
}
