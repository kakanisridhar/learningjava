package com.mridasoft.learning.concurrency.Executors;

import java.util.Random;
import java.util.concurrent.*;

public class SimpleExecutorTest implements Callable<Integer> {
	
	Random rnd = new Random(365);
	
	@Override
	public Integer call() throws Exception {
		TimeUnit.SECONDS.sleep(30);
		return rnd.nextInt();
	}
	
	public static void main(String[] args) {
		ExecutorService execServ =  Executors.newFixedThreadPool(10);
		Future<Integer> f1 = execServ.submit(new SimpleExecutorTest());
		int val = -1;
		try {
			val = f1.get();
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		System.out.println("val="+val);
		execServ.shutdown();
		Future<Integer> f2 =  execServ.submit(new SimpleExecutorTest());
		try {
			int val2 = f2.get();
			System.out.println("val2="+val2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		
	}

}
