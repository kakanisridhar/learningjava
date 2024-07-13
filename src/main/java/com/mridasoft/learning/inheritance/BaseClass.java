package com.mridasoft.learning.inheritance;

public class BaseClass implements MyIntfc {
	
	int somVal = 1;
	
	public BaseClass() {
		
	}
		
	public void printSomeVal() {
		System.out.println("BaseClass-"+somVal);
	}

}
