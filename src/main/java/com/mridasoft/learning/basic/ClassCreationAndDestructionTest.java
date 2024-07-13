package com.mridasoft.learning.basic;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ClassCreationAndDestructionTest {
	
	public static void main(String[] args) {
		
		List<HeavyClass> heavyclasses = new ArrayList<>();
		
		Runtime.getRuntime().gc();
		
		System.out.println( "total memory = "+ Runtime.getRuntime().totalMemory()/(1024*1024) + " MB");
		System.out.println( "free memory = "+ Runtime.getRuntime().freeMemory()/(1024*1024) + " MB");
		
		for(int i=0;i < 32; i++)
			heavyclasses.add(new HeavyClass());
		
		//32 * 4 mb should have got allocated
		
		System.out.println( "after allocation free memory = "+ Runtime.getRuntime().freeMemory()/(1024*1024) + " MB");
		BinaryWriter.writeToFile(heavyclasses, new File("ClassCreationAndDestructionTest-all"));
		BinaryWriter.writeToFile(new HeavyClass(), new File("ClassCreationAndDestructionTest-oneobject"));
		heavyclasses = null;
		Runtime.getRuntime().gc();
		
		try {
			TimeUnit.SECONDS.sleep(60);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println( "after destruction free memory = "+ Runtime.getRuntime().freeMemory()/(1024*1024) + " MB");
		System.out.println( "****DONE****");
	}
	
}
