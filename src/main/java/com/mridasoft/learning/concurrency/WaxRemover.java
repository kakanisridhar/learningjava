package com.mridasoft.learning.concurrency;

import java.util.concurrent.TimeUnit;

public class WaxRemover implements Runnable {

	private Car car;

	public WaxRemover(Car c) {
		car = c;
	}

	@Override
	public void run() {
		Thread.currentThread().setName("WaxRemover");
		try {
			while (!Thread.interrupted()) {
				car.waitForWaxing();
				System.out.println("Removing wax");
				TimeUnit.SECONDS.sleep(1);// simulate work
				car.buffed();
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Car wax removal done");
	}

}
