package com.mridasoft.learning.concurrency.Executors;

import java.util.concurrent.atomic.AtomicLong;

public class Resource {

	private static AtomicLong instanceCount = new AtomicLong();
	
	private boolean isDisposed;
	
	public Resource() {
		instanceCount.incrementAndGet();
	}
	
	public void dispose() {
		if(!isDisposed) {
			instanceCount.decrementAndGet();
			isDisposed = true;
		}
	}
	
	public static long instancesInMemory() {
		return instanceCount.get();
	}
	
}
