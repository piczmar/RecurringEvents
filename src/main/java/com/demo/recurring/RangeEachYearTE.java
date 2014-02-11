package com.demo.recurring;

import java.util.Date;

/**
 * The heating is turned off on the 14 April and turned on the 12th October.
 * This could be represented as a range each year temporal expression with a
 * start month of April, start date of 14, end month of October, and end date of
 * 12. Using RangeEachYearTE it would be set up with RangeEachYearTE (3, 9, 14,
 * 12)
 * 
 */
public class RangeEachYearTE extends TemporalExpression{
	private int startMonth;
	private int startDay;
	private int endMonth;
	private int endDay;

	RangeEachYearTE(int startMonth, int endMonth, int startDay, int endDay) {
		this.startMonth = startMonth;
		this.endMonth = endMonth;
		this.startDay = startDay;
		this.endDay = endDay;
	};

	public RangeEachYearTE(int startMonth, int endMonth) {
		this.startMonth = startMonth;
		this.endMonth = endMonth;
		this.startDay = 0;
		this.endDay = 0;
	};

	public RangeEachYearTE(int month) {
		this.startMonth = month;
		this.endMonth = month;
		this.startDay = 0;
		this.endDay = 0;
	};

	public boolean includes(Date aDate) {
		return monthsInclude(aDate) || startMonthIncludes(aDate)
				|| endMonthIncludes(aDate);
	};

	private boolean monthsInclude(Date aDate) {
		int month = aDate.getMonth();
		return (month > startMonth && month < endMonth);
	}

	private boolean startMonthIncludes(Date aDate) {
		if (aDate.getMonth() != startMonth)
			return false;
		if (startDay == 0)
			return true;
		return (aDate.getDate() >= startDay);
	}

	private boolean endMonthIncludes(Date aDate) {
		if (aDate.getMonth() != endMonth)
			return false;
		if (endDay == 0)
			return true;
		return (aDate.getDate() <= endDay);
	}
}
