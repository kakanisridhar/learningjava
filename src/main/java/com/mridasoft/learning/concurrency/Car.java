package com.mridasoft.learning.concurrency;

public class Car {

	public String name;
	
	private boolean waxon = true;
	
	public synchronized void waxed() {
		waxon = true;
		notifyAll();
	}
	
	public synchronized void buffed() {
		waxon = false;
		notifyAll();
	}
	
	public synchronized void waitForWaxing() throws InterruptedException {
		while(waxon==false){
			System.out.println("waitForWaxing-before wait");
			wait();
			System.out.println("waitForWaxing-after wait");
		}
	}
	
	public synchronized void waitForBuffing() throws InterruptedException  {
		while(waxon==true) {
			System.out.println("waitForBuffing-before wait");
			wait();
			System.out.println("waitForBuffing-after wait");
		}
			
	}
}
