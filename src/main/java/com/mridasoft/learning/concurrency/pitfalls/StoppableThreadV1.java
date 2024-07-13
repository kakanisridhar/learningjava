package com.mridasoft.learning.concurrency.pitfalls;

import java.util.concurrent.TimeUnit;

public class StoppableThreadV1 
{
	
	public static class StoppableTask implements Runnable
	{
		//will not work , because it is not volatile
		private boolean stopMe;
		
		@Override
		public void run() {
			while(!stopMe) {
				//
			}
			System.out.println("Stopped"+System.currentTimeMillis());
		}
		
		public void stop() {
			stopMe = true;
		}
	}
	
	public static void main(String[] args) {
		StoppableTask task = new StoppableTask();
		Thread t = new Thread(task);
		t.start();
		
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("killing task"+System.currentTimeMillis());
		task.stop();
		
	}

}
