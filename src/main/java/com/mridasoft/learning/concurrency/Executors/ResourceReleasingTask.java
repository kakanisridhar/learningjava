package com.mridasoft.learning.concurrency.Executors;

public interface ResourceReleasingTask extends Runnable {

	void releaseResources();
	
}
