package com.mridasoft.learning.concurrency;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class StatsUpdater implements Runnable {

	private final StatsCollector stats;
	private final List<String> queues = Arrays.asList("Q1","Q2","Q3","Q4","Q5","Q6","Q7");
	Random randomGenerator = new Random();
	
	public StatsUpdater(StatsCollector stats) {
		this.stats = stats;
	}

	@Override
	public void run() {
		int randomInt = randomGenerator.nextInt(queues.size()); 
		String qn = queues.get(randomInt);
		stats.addStat(qn);
	}

	
}
