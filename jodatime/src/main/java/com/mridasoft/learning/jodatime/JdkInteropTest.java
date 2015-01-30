package com.mridasoft.learning.jodatime;

import java.util.Calendar;
import java.util.Date;

import org.joda.time.DateTime;

public class JdkInteropTest {
	
	public static void main(String[] args) {
		
	    DateTime dt = new DateTime();
	    Date jdkDate = dt.toDate();
	    System.out.println(jdkDate);
	    // from JDK to Joda
	    Calendar cal = Calendar.getInstance();
  		cal.set(2009, 6, 4, 12, 30, 59);
  		
  		Date d = new Date(cal.getTimeInMillis());
  		System.out.println(d);
	    dt = new DateTime(d);
	    System.out.println(dt);
	}

}
