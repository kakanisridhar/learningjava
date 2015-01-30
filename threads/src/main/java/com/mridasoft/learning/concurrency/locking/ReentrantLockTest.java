package com.mridasoft.learning.concurrency.locking;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest {
	
	private final ReentrantLock lock = new ReentrantLock();
	
	private void simpleTest() {
		
		lock.lock();
		
		try {
			System.out.println("locked!!");
			try {
				methodA();
			} catch (Exception e) {
				System.out.println("OOOOOOOOK");
			}
		} finally {
			System.out.println("Releasing lock");
			lock.unlock();
		}
		System.out.println(lock.isLocked());
	}
	
	private void methodA() throws Exception {
		throw new Exception("definite exception");
	}
	
	public static void main(String[] args) {
		ReentrantLockTest test = new ReentrantLockTest();
		test.simpleTest();
	}

}
