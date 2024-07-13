package com.mridasoft.learning.basic;

import java.io.Serializable;

public class HeavyClass implements Serializable{
	
	private static final long serialVersionUID = -7019382467625337718L;

	//keeps track of count
	static int i;
	
	//1024*1024*4 bytes even on 64 bit vm
	int[] mycals = new int[1024*1024];
	
	int mynum;
	
	public HeavyClass() {
		mynum = i++;
	}
	
	@Override
	protected void finalize() throws Throwable {
		System.out.println("~ClassCreationAndDestruction - "+mynum);
	} 

}
