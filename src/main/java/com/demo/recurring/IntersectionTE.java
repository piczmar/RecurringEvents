package com.demo.recurring;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class IntersectionTE extends TemporalExpression {

	List<TemporalExpression> elements = new ArrayList<TemporalExpression>();

	@Override
	public boolean includes(Date aDate) {
		for (TemporalExpression e : elements) {
			if (!e.includes(aDate))
				return false;
		}
		return false;
	}
	
	public void add(TemporalExpression e) {
		elements.add(e);
	}

}
