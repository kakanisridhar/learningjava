package com.mridasoft.learning.concurrency;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map.Entry;

public class StatsPublisher implements Runnable {
	
	private final StatsCollector stats;
	
	public StatsPublisher(StatsCollector stats) {
		super();
		this.stats = stats;
	}

	@Override
	public void run() {
		publishStats();
		
		saveStats();
		
	}

	private void publishStats() {
		System.out.println("stats:");
		HashMap<String, Integer> state = stats.getStatsByQueueName();
		
		for(Entry<String, Integer> entry : state.entrySet()) {
			System.out.print(entry.getKey() + ":" + entry.getValue() + "\t");
		}
	}

	private void saveStats() {
		System.out.println("saving to mem");
		/*try(ObjectOutputStream oStream = new ObjectOutputStream(new ByteArrayOutputStream(64))) {
			oStream.writeObject(stats);
		} catch (IOException e) {
			e.printStackTrace();
		}*/
		
		try {
		
		 ByteArrayOutputStream bytesOut = new ByteArrayOutputStream();
         OutputStream os = bytesOut;
         DataOutputStream dataOut = new DataOutputStream(os);
         ObjectOutputStream objOut = new ObjectOutputStream(dataOut);
         objOut.writeObject(stats);
         objOut.flush();
         objOut.reset();
         objOut.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
				
				
	}
}
