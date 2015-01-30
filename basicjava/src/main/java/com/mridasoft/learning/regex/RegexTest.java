package com.mridasoft.learning.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTest {
	
	public static void main(String[] args) {
		String regex = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{4,8}$";
		String value = "0aLr";
		
		Pattern pattern  = Pattern.compile(regex);
		Matcher matched = pattern.matcher(value);
		
		//System.err.println(matched.matches());
		System.err.println(matched.find());
			
	}

}
