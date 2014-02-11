package com.demo.recurring;

import java.util.Date;

public class ScheduleElement {
	
	TemporalExpression temporalExpression;
	String event;
	

	public boolean isOccurring(String eventArg, Date aDate) {
		if (event == eventArg)
			return temporalExpression.includes(aDate);
		else
			return false;
	}

}
