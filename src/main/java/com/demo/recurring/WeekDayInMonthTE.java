package com.demo.recurring;

import java.util.Calendar;
import java.util.Date;

/**
 * Mark has a gastro clinic on the second monday of the month. This would be
 * represented using a day in month temporal expression with a day of the week
 * of monday and a count of 2. Using Listing 3 this would be DayInMonthTE (1, 2)
 */
public class WeekDayInMonthTE extends TemporalExpression {

	private int count;
	private int dayIndex;

	public WeekDayInMonthTE(int dayIndex, int count) {
		this.dayIndex = dayIndex;
		this.count = count;
	};

	public boolean includes(Date aDate) {
		return dayMatches(aDate) && weekMatches(aDate);
	};

	private boolean dayMatches(Date aDate) {
		return aDate.getDay() == dayIndex;
	};

	private boolean weekMatches(Date aDate) {
		if (count > 0)
			return weekFromStartMatches(aDate);
		else
			return weekFromEndMatches(aDate);
	};

	private boolean weekFromStartMatches(Date aDate) {
		return this.weekInMonth(aDate.getDate()) == count;
	};

	private boolean weekFromEndMatches(Date aDate) {
		int daysFromMonthEnd = daysLeftInMonth(aDate) + 1;
		return weekInMonth(daysFromMonthEnd) == Math.abs(count);
	};

	private int daysLeftInMonth(Date aDate) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(aDate);
		int daysInMonth = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		int dayInMonth = cal.get(Calendar.DAY_OF_MONTH);
		return daysInMonth - dayInMonth;
	}

	private int weekInMonth(int dayNumber) {
		return ((dayNumber - 1) / 7) + 1;
	};

}
