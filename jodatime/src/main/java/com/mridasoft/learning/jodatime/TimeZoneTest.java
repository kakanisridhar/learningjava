package com.mridasoft.learning.jodatime;

import org.joda.time.Chronology;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.chrono.ISOChronology;

public class TimeZoneTest {

	public static void main(String[] args) {
		
		DateTimeZone defaultZone = DateTimeZone.getDefault();
		System.out.println("i am on time zone : "+ defaultZone);
	}
	
}
