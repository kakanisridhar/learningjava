package com.mridasoft.learning.concurrency;

import java.io.Serializable;
import java.util.HashMap;

public class StatsCollector implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private HashMap<String, Integer> statsByQueueName = new HashMap<>();
	
	public HashMap<String, Integer> getStatsByQueueName() {
		return statsByQueueName;
	}
	
	public void addStat(String name) {
		Integer stat = statsByQueueName.get(name);
		if(stat==null) {
			stat = new Integer(-1);
		}
		stat = stat + 1;
		statsByQueueName.put(name, stat);
	}

}
