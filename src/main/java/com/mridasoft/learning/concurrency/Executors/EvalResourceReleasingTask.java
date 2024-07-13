package com.mridasoft.learning.concurrency.Executors;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class EvalResourceReleasingTask {
	
	public static void main(String[] args) {
		
		ResourceReleasingSchedThreadPoolExecutor executor = new ResourceReleasingSchedThreadPoolExecutor(Integer.MAX_VALUE);
		
		List<MyConnectionChecker> users = new ArrayList<>();
		
		for(int i = 0 ; i< 10 ; i++) { 
			MyConnectionChecker conChecker = new MyConnectionChecker("conchecker"+i, executor);
			users.add(conChecker);
		}
		
		
		try {
			TimeUnit.MINUTES.sleep(1);
		} catch (InterruptedException e) {
		}
		
		users.get(5).shutDown();
		users.set(5, null);
		System.out.println(executor.getSize());
		
		try {
			TimeUnit.MINUTES.sleep(1);
		} catch (InterruptedException e) {
		}
		
		executor.shutdown();
		
		System.out.println("done-"+Resource.instancesInMemory());
		
		executor.shutdownNow();
		
	}

}
