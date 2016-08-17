package com.github.stock_data.common.util;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;

public class DateHelper {
	static String DATE_FORMAT = "yyyy-MM-dd";
	
	public static List<DateRange> genDayWeekMonth(Date date,String dateFormat) {
		List<DateRange> result = new ArrayList<DateRange>();
		DateRange day = new DateRange(date,date,dateFormat,"day");
		DateRange week = new DateRange(getStartDate(date,"week"),getEndDate(date,"week"),dateFormat,"week");
		DateRange month = new DateRange(getStartDate(date,"month"),getEndDate(date,"month"),dateFormat,"month");
		
		/*
		if(!day.getEnd().equals(week.getEnd())) {
			week = null;
		}
		if(!day.getEnd().equals(month.getEnd())) {
			month = null;
		}
		*/
		
		CollectionUtils.addIgnoreNull(result, day);
		CollectionUtils.addIgnoreNull(result, week);
		CollectionUtils.addIgnoreNull(result, month);
		
		return result;
	}
	
	// 返回日历
	public static Calendar getCalendar(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar;
	}
	
	public static Date getStartDate(Date date,String rangeType) {
		Calendar calendar = getCalendar(date);
		if (rangeType.equals("week")) {
			calendar.setFirstDayOfWeek(Calendar.MONDAY);
			calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		}
		if (rangeType.equals("month")) {
			calendar.set(Calendar.DAY_OF_MONTH, 1);
		}
		return calendar.getTime();
	}
	
	public static Date getEndDate(Date date,String rangeType)
	{
		if (date == null || rangeType == null)
			throw new RuntimeException("Date and rangeType must be not null");
		Calendar calendar = getCalendar(date);
		if (rangeType.equals("week")) {
			calendar.setFirstDayOfWeek(Calendar.MONDAY);
			calendar.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
		}
		if (rangeType.equals("month")) {
			calendar.set(Calendar.DAY_OF_MONTH, 1);
			calendar.roll(Calendar.DAY_OF_MONTH, -1);
		}

		calendar.set(Calendar.HOUR_OF_DAY, 23);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND, 59);
		calendar.set(Calendar.MILLISECOND, 999);
		return calendar.getTime();
	}
}
