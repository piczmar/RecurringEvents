package com.demo.recurring;

import java.util.Date;

public abstract class TemporalExpression {
	public abstract boolean includes(Date date);
}
