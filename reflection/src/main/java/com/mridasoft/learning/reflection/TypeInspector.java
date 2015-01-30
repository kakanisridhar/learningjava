package com.mridasoft.learning.reflection;

public class TypeInspector {

	public static void printTypeInfo(Class<?> clazz) {
		System.out.println("primitive type-"+clazz.isPrimitive());
	}
	
	public static void main(String[] args) {
		final int[][] INT_ARR = new int[4][4];
		final int AGE  = 32;
		printTypeInfo(int.class);
	}
	
}
