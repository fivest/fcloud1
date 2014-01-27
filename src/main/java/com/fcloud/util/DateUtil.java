package com.fcloud.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
	public static String convertDateToString(String pattern, Date date) {
		if (date == null)
			return null;
		if (StringUtil.isNull(pattern)) {
			pattern = "yyyy-mm-dd";
		}
		SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
		return dateFormat.format(date);
	}

	/**
	 * 日期相加减，如果参数date为空，则取当前日期，days为天数，正数为加，负数为减
	 * 
	 * @param date
	 * @param days
	 * @return
	 */
	public static Date addOrSubDate(Date date, int days) {
		Calendar calendar = Calendar.getInstance();
		if (date != null) {
			calendar.setTime(date);
		}
		calendar.add(Calendar.DATE, days);
		return calendar.getTime();
	}

	public static void main(String[] args) {
		System.out.println(convertDateToString(null, null));
		System.out.println(convertDateToString(null, new Date()));
		System.out.println(convertDateToString("yyyymmdd", new Date()));
	}
}
