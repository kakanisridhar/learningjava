package com.mridasoft.learning.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EverRunningThreadV1 {

	private static class PrimeCalculator implements Runnable {
		@Override
		public void run() {
			while (true) {
				// i am lazy i dont do anything
				
				//if i dont do this no one can stop me from running for ever
				if (Thread.interrupted()) {
					System.out.println("Cant you just wait");
				    return;
				}
			}
		}
	}

	private void calcPrimes() {
		
		ExecutorService singlThreadedExecutor = Executors.newSingleThreadExecutor();
		
		singlThreadedExecutor.submit(new PrimeCalculator());

		try
		{
			Thread.sleep(100*60);
		}
		catch (InterruptedException e) {
			System.out.println("I woke Up");
		}
		
		System.out.println("Calling shutdown");
		singlThreadedExecutor.shutdownNow();
	}

	public static void main(String[] args) {
		EverRunningThreadV1 app = new EverRunningThreadV1();
		System.out.println("Calling calc primes");
		app.calcPrimes();
		System.out.println("after calling calc primes");
	}

}
