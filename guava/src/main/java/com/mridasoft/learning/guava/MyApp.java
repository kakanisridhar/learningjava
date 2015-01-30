package com.mridasoft.learning.guava;

import java.util.concurrent.TimeUnit;

import com.google.common.util.concurrent.Service;

public class MyApp {
	
	public static void main(String[] args) {
		Service HAHAHA = new MyService("Service A version 1");
		HAHAHA.startAndWait();
		try {
			TimeUnit.MINUTES.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(HAHAHA.state());
		HAHAHA.stopAndWait();
	}

}
