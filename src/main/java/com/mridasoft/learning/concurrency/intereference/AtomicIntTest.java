package com.mridasoft.learning.concurrency.intereference;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntTest implements Callable<List<Integer>> {
	
		private AtomicInteger seq;
		 
		public AtomicIntTest(AtomicInteger s) {
			this.seq = s;
		}
		
		@Override
		public List<Integer> call() throws Exception {
			
			List<Integer> mySeq = new ArrayList<>();
			
			for(int i = 0 ; i<10; i++) {
				int val = seq.incrementAndGet();
				mySeq.add(val);
				try {
					Thread.sleep(100*1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
			return mySeq;
		}
		
		public static void main(String[] args) {
			
			ExecutorService serv = Executors.newFixedThreadPool(10);
			Map<Integer,MutableInt> map = new TreeMap<>();
			AtomicInteger ai = new AtomicInteger(); 
			
			List<Future<List<Integer>>> vals = new ArrayList<>();
			
			for(int i = 0 ;i< 10; i++) {
				vals.add( serv.submit(new AtomicIntTest(ai)) );
			}
			
			
			for (Iterator iterator = vals.iterator(); iterator.hasNext();) {
				
				Future<List<Integer>> future = (Future<List<Integer>>) iterator.next();
				try {
					List<Integer> sqs = future.get();
					for(int s : sqs)
					{
							MutableInt count = map.get(s);
							if (count == null) {     
								map.put(s, new MutableInt()); 
							}
							else
							{ 
								count.increment(); 
							} 
					}
						
				} catch (InterruptedException | ExecutionException e) {
					e.printStackTrace();
				}
			}
			
			for(int i : map.keySet())
			{
				System.out.println(i+"="+map.get(i).get());
			}
			
			serv.shutdownNow();
			System.out.println("I am not assuming any dups");
		}
}
