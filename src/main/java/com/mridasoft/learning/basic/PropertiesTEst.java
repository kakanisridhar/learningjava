package com.mridasoft.learning.basic;

import java.util.Iterator;
import java.util.Properties;

public class PropertiesTEst {
	
	public static void main(String[] args) {
		Properties props1 = new Properties();
		props1.put("A", "AVAL");
		
		Properties props2 = new Properties(props1);
		Properties props3 = (Properties) props1.clone();
		props1.setProperty("A_1", "A_1VAL");
		
		printVals("props1",props1);
		printVals("props2",props2);
		printVals("props3",props3);
	}

	static void printVals(String s, Properties p) {
		System.out.println("listing properties-"+s);
		Iterator i = p.keySet().iterator();
		while(i.hasNext()) {
			String k = (String) i.next();
			String v = p.getProperty(k);
			System.out.println(k+"="+v);
		}
		System.out.println(p.get("A"));
	}
}
