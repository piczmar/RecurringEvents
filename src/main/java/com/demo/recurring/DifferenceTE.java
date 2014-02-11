package com.demo.recurring;

import java.util.Date;

public class DifferenceTE extends TemporalExpression {
	private TemporalExpression included;
	private TemporalExpression excluded;

	public DifferenceTE(TemporalExpression included, TemporalExpression excluded) {
		this.included = included;
		this.excluded = excluded;
	}

	@Override
	public boolean includes(Date aDate) {
		return included.includes(aDate) && !excluded.includes(aDate);
	}

}
