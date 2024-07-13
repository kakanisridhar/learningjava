package com.mridasoft.learning.inheritance;

public class Test {
	
	public static void main(String[] args) {
		BaseClass b = new DerivedClass();
		System.out.println(b.somVal);
		b.printSomeVal();
		
		DerivedClass d = (DerivedClass) b;
		System.out.println(d.somVal);
		d.printSomeVal();
	}

}
