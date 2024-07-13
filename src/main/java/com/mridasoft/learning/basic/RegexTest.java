package com.mridasoft.learning.basic;

public class RegexTest {
	public static void main(String[] args) {
		String ver = "1.7.0";
		
		//splitAndPrintOnDot(ver);
		
		//splitAndPrintOnDot("1");
		
		wrongSplitAndPrint("com.mridasoft");
	}
	
	static void splitAndPrintOnDot(String ver) {
		
		String regex = "\\.";
		String[] arr = ver.split(regex, 2);
		System.out.println(arr[0]);
		System.out.println(arr[1]);
	}
	
	static void wrongSplitAndPrint(String ver) {
		
		String regex = "\\.";
		String[] arr = ver.split(regex);
		System.out.println(arr[0]);
		System.out.println(arr[1]);
	}
}
