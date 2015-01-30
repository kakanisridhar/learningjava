package com.mridasoft.learning.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Wildcards1 {
	
	
	private void workonNumber(List<? extends Number> numbers) {
		//this wont succeed as list 
		//numbers.add((Integer)1);
		System.out.println("numbers-"+numbers);
	}
	
	private void workonTypes(List<? extends TypeA> alist) {
		for(TypeA i : alist) {
			System.out.println(i.toString());
		}
	}
	
	public static void main(String[] args) {
		
		Wildcards1 app = new Wildcards1();
		
		List<Integer> intlist = Arrays.asList(1,2,3);
		
		app.workonNumber(intlist);
		
		List<Double> fltlist = new ArrayList<>();
		fltlist.add(1.55555555);
		fltlist.add(2.222222);
		fltlist.add(3.55555555);
		
		app.workonNumber(fltlist);
		
		System.out.println("working on List of TypeA");
		List<TypeA> l1  = new ArrayList<>();
		l1.add(app.new TypeA(1));
		l1.add(app.new TypeB(2));
		l1.add(app.new TypeC(3));
		app.workonTypes(l1);
		
		System.out.println("working on List of TypeB");
		List<TypeB> l2  = new ArrayList<>();
		l1.add(app.new TypeB(4));
		l1.add(app.new TypeC(5));
		app.workonTypes(l2);
		
	}
	
	private class TypeZero {
		
		@Override
		public String toString() {
			return "TypeZero";
		}
		
	}
	
	private class TypeA extends TypeZero{
		
		int id;
		
		public TypeA(int id) {
			System.out.println("Type A");
			this.id = id;
		}
		
		public int getId() {
			return id;
		}
		
		@Override
		public String toString() {
			return "TypeA-"+getId();
		}
	}
	
	private class TypeB extends TypeA {
		public TypeB(int id) {
			super(id);
			System.out.println("Type A");
		}

		@Override
		public String toString() {
			return "TypeB-"+getId();
		}

	}
	
	private class TypeC extends TypeA {
		public TypeC(int id) {
			super(id);
			System.out.println("Type C");
		}
		
		@Override
		public String toString() {
			return "TypeC-"+getId();
		}
	}
}


