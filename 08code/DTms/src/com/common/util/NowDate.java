package com.common.util;

import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

public class NowDate {

	public static String getDateJiSuan(String dates, int i) {
		String dateString = null;
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date da = null;
		try {
			da = formatter.parse(dates);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		da.setTime(da.getTime() + (86400000 * 10));
		dateString = formatter.format(da);
		return dateString;
	}

	public static Date getNowDateShort() {
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String dateString = formatter.format(currentTime);
		ParsePosition pos = new ParsePosition(8);
		Date currentTime_2 = formatter.parse(dateString, pos);
		return currentTime_2;
	}

	public static String getStringDateShort() {
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String dateString = formatter.format(currentTime);
		return dateString;
	}

	public static String getStringDateShortHSS() {
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String dateString = formatter.format(currentTime);
		return dateString;
	}

	public static Date getStringDateShortHSSDate() {
		Date currentTime = new Date();
		// SimpleDateFormat formatter = new
		// SimpleDateFormat("yyyy-MM-dd-hh-mm-ss");
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String dateString = formatter.format(currentTime);
		System.out.println(dateString);
		Date da = StringDate(dateString);
		return da;
	}

	public static java.sql.Date StringDate(String str) {
		// SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		java.util.Date timeDate = null;
		try {
			timeDate = sdf.parse(str);
		} catch (ParseException e) {
			// TODO
			e.printStackTrace();
		}
		java.sql.Date dates = new java.sql.Date(timeDate.getTime());// sql����
		return dates;
	}

	public static java.sql.Date getNowDate() {
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String dateString = formatter.format(currentTime);
		java.sql.Date dates = StringDate(dateString);
		return dates;
	}

	public static java.sql.Date StringToDate(String str) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date timeDate = null;
		try {
			timeDate = sdf.parse(str);
		} catch (ParseException e) {
			// TODO
			e.printStackTrace();
		}
		java.sql.Date dates = new java.sql.Date(timeDate.getTime());
		return dates;
	}
}
