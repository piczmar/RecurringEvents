package com.demo.recurring.date;

import java.util.Date;

public class DateRange {
	private Date from;
	private Date to;
	
	public Date getFrom() {
		return from;
	}
	public Date getTo() {
		return to;
	}

	public DateRange(Date from , Date to){
		this.from= from;
		this.to = to;
	}
	
}
