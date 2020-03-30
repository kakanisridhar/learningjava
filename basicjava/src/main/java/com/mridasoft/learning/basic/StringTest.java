package com.mridasoft.learning.basic;

public class StringTest {
	public static void main(String[] args) {
		String ver = "1.7.0";
		String[] arr = ver.split("\\.", 2);
		System.out.println(arr[0]);
		System.out.println(arr[1]);
		
		String arg = "SK";
		
		switch(arg) {
		case "SK":
			System.out.println("got sk");
		break;	
		}
	}
}
