package com.mridasoft.learning.jodatime;

import org.joda.time.DateTime;
import org.joda.time.Period;

public class PeriodTest {

	public static void main(String[] args) {
		Period p = new Period().withWeeks(1);
		System.out.println(p.toStandardDays().getDays());
		
		DateTime dt = new DateTime();
		DateTime added = dt.plus(p);
		
		System.out.println(added);
	}
	
}
