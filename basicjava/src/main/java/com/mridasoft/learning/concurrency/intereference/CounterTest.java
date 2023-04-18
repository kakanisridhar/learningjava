package com.mridasoft.learning.concurrency.intereference;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/*
 * this is overkill
 * I started thinking of learning thread interleaving and ended up with executors, futures
 * 
 * Definitely methods of counter has to be synchronized
 *  
*/ 
public class CounterTest implements Callable<List<Integer>> {

	//replacing this with AtomicIntCounter wont do any good
	private Counter seq;
	 
	public CounterTest(Counter s) {
		this.seq = s;
	}
	
	@Override
	public List<Integer> call() throws Exception {
		
		List<Integer> mySeq = new ArrayList<>();
		
		//wait a second so that all will start
		
		try {
			Thread.sleep(1000*1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		for(int i = 0 ; i<10; i++) {
			seq.increment();
			int val = seq.value();
			System.out.println(Thread.currentThread().getName() + " " + val);
			mySeq.add(val);
		}
		
		return mySeq;
	}
	
	public static void main(String[] args) {
		
		Counter seq = new Counter();
		ExecutorService serv = Executors.newFixedThreadPool(10);
		Map<Integer,MutableInt> map = new TreeMap<>();
		
		List<Future<List<Integer>>> vals = new ArrayList<>();
		
		for(int i = 0 ;i< 10; i++) {
			vals.add( serv.submit(new CounterTest(seq)) );
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
		System.out.println("Guess i will get some interleaving");
	}
}
