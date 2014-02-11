package com.demo.recurring;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import com.demo.recurring.date.DateRange;

public class Schedule {

	List<ScheduleElement> elements = new ArrayList<ScheduleElement>();

	public boolean isOccurring(String eventArg, Date aDate) {
		for (ScheduleElement e : elements) {

			if (e.isOccurring(eventArg, aDate)) {
				return true;
			}
		}
		return false;
	}

	public Vector dates(String eventArg, DateRange during) {
		return null;
	}

	public Date nextOccurence(String eventArg, Date aDate) {
		return null;
	}
}
