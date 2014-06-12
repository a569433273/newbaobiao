package com.liu.baobiao.util;

public enum TimeZhuan {
	JAN, FEB, MAR, APR, MAY, JUN, JUL, AUG, SEP, OCT, NOV, DEC;

	public static TimeZhuan getTimezhuan(String time) {
		return valueOf(time);
	}
}
