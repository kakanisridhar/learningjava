package com.mridasoft.learning.generics;

import java.util.ArrayList;
import java.util.List;



public class Wildcards2 {
	

	//README:that means it accepts all lists which hold elements of types inherited from TypeA 
	private void workonTypes(List<? super TypeA> alist) {
		alist.add(new TypeB());
		alist.add(new TypeC());
		//alist.add(new TypeZero());
	}
	

	public static void main(String[] args) {
		
		Wildcards2  a= new Wildcards2();
		
		System.out.println("working on types with same list as method");
		List<? super TypeA> list = new ArrayList<>();
		a.workonTypes(list);
		
		
		//README: even container declaration must match		
		//List<TypeB> list1 = new ArrayList<>();
		//a.workonTypes(list1);
		
		//README: List<TypeA> is a subtype of list accepted by method
		System.out.println("working on types with list of typea elements");
		List<TypeA> list1 = new ArrayList<>();
		a.workonTypes(list1);
		
	}
	
	private class TypeZero {
		
		public TypeZero() {
			System.out.println("Type 0");
		}
	}

	private class TypeA extends TypeZero{
		
		public TypeA() {
			System.out.println("Type A");
		}
	}
	
	private class TypeB extends TypeA {
		public TypeB() {
			System.out.println("Type B");
		}
	}
	
	private class TypeC extends TypeB {
		public TypeC() {
			System.out.println("Type C");
		}
	}
	
}
