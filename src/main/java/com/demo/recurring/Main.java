package com.demo.recurring;

public class Main {
	public static void main(String args[]) {
		IntersectionTE result = new IntersectionTE();
		result.add(new WeekDayInMonthTE(1, -1));
		result.add(new RangeEachYearTE(4));

	}

	public DifferenceTE streetCleaning() {
		UnionTE mon13 = new UnionTE();
		mon13.add(new WeekDayInMonthTE(1, 1));
		mon13.add(new WeekDayInMonthTE(1, 3));
		IntersectionTE nonWinterMons = new IntersectionTE();
		nonWinterMons.add(mon13);
		nonWinterMons.add(new RangeEachYearTE(3, 9));
		return new DifferenceTE(nonWinterMons, maHolidays());
	}

	private TemporalExpression maHolidays() {
		UnionTE holidays = new UnionTE();
		holidays.add(new WeekDayInMonthTE(1, 1));//first monday of the month
		holidays.add(new WeekDayInMonthTE(2, 2));//second tuesday of the month\
		return holidays;
	}
}
