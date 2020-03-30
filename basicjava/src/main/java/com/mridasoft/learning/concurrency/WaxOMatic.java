package com.mridasoft.learning.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class WaxOMatic {
	public static void main(String[] args) throws Exception {
		Car car = new Car();
		ExecutorService exec = Executors.newCachedThreadPool();
		exec.execute(new Waxer(car));
		exec.execute(new WaxRemover(car));
		TimeUnit.SECONDS.sleep(60); //Run for a w h i l e . ..
		exec.shutdownNow(); // Interrupt a l l tasks
	}
}