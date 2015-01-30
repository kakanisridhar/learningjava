package com.mridasoft.learning.concurrency;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TryForConcurrentModException {
	
	public static void main(String[] args) {
		
		StatsCollector collector = new StatsCollector();
		
		/*List<String> qs = Arrays.asList("Q1","Q2","Q3","Q4","Q5","Q6","Q7");
		
		collector.addStat("Q1");
		collector.addStat("Q2");
		collector.addStat("Q3");
		collector.addStat("Q4");
		collector.addStat("Q5");
		collector.addStat("Q6");
		collector.addStat("Q7");*/
		
		ScheduledExecutorService pub =  Executors.newScheduledThreadPool(1);
		
		pub.scheduleAtFixedRate(new StatsPublisher(collector) , 1, 1, TimeUnit.SECONDS);
		
		pub.scheduleAtFixedRate(new StatsUpdater(collector) , 1, 1, TimeUnit.SECONDS);
		
		try {
			TimeUnit.MINUTES.sleep(3);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.exit(1);
		
	}

}
