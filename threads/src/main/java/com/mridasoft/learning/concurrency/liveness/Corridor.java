package com.mridasoft.learning.concurrency.liveness;

// this is incomplete example, thought of simulating a livelock
public class Corridor 
{
	private int capacity;
	private Object left, right;

	public void goLeft(Object person, boolean direction){
		//some one is using corridor
		//prevent others from using it
	}
	
	public void goRight(Object person, boolean direction){
		//some one is using corridor
		//prevent others from using it
	}
	
	public void doneUsing() {
		//i am done using i wont tell what lock i hold, so release yourself
	}
	
	public void registerListener() {
		//broadcast 
	}
}
