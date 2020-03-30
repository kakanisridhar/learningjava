package com.mridasoft.learning.inheritance;

public class DerivedClass extends BaseClass{
	
	int somVal = 2;
	
	public DerivedClass() {
		
	}
		
	public void printSomeVal() {
		System.out.println("DerivedClass-"+somVal);
	}

}
