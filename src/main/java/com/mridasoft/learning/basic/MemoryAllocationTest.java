package com.mridasoft.learning.basic;

public class MemoryAllocationTest {

	    public static void main(String[] args) {

	        Runtime runtime = Runtime.getRuntime();

	        for (int i = 0; true; i++) {
	            runtime.gc();
	            int size = i * 10000000;
	            System.out.println("                 i is " + i);
	            System.out.println("              size is " + size);
	            System.out.println("b       freememory is " + runtime.freeMemory());
	            System.out.println("b the total memory is " + runtime.totalMemory());
	            System.out.println("b   the max memory is " + runtime.maxMemory());
	            byte[] testArray = new byte[size];
	            System.out.println("                array " + testArray.length);
	            System.out.println("a       freememory is " + runtime.freeMemory());
	            System.out.println("a the total memory is " + runtime.totalMemory());
	            System.out.println("a   the max memory is " + runtime.maxMemory());
	            System.out.println(" ");
	        }
	    } 
}
