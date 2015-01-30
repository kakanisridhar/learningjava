package com.mridasoft.learning.jodatime;

import org.joda.time.DateTime;
import org.joda.time.Interval;
import org.joda.time.Period;
import org.joda.time.PeriodType;
import org.joda.time.chrono.ISOChronology;

public class DateTimeTest {
	
	public static void main(String[] args) {
		DateTime dt = new DateTime(2004, 12, 31, 12, 30, 1, 30, ISOChronology.getInstance());
		System.out.println(dt);
	}

}
