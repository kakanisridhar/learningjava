package com.mridasoft.learning.concurrency.Executors;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class MyConnectionChecker implements ResourceReleasingTask {

	
	private final ScheduledFuture<?> thisTask;
	
	private final Resource resource;
	
	private final String name;
	
	private long howManyThreads;
	
	public MyConnectionChecker(String name,ScheduledExecutorService executorService) {
		thisTask =  executorService.scheduleAtFixedRate(this, 10, 10, TimeUnit.SECONDS);
		resource = new Resource();
		this.name = name;
	}
	

	@Override
	public void run() {
		howManyThreads++;
		System.out.println("Checking Connection-"+name);
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			System.out.println("interrupted");
		}
		System.out.println("Done-"+name+"-"+howManyThreads);
	}

	@Override
	public void releaseResources() {
		System.out.println(name + " Releasing Resources");
		resource.dispose();
	}
	
	public void shutDown() {
		thisTask.cancel(true);
		//resource.dispose();
	}

}
