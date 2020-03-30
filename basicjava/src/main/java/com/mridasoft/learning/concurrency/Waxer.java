package com.mridasoft.learning.concurrency;

import java.util.concurrent.TimeUnit;

public class Waxer implements Runnable {

	private Car car;

	public Waxer(Car c) {
		car = c;
	}

	@Override
	public void run() {
		Thread.currentThread().setName("Waxer");
		try {
			while (!Thread.interrupted()) {

				TimeUnit.SECONDS.sleep(1);// simulate work
				System.out.println("Waxed");
				car.waxed();
				car.waitForBuffing();

			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Car waxing done");
	}

}
