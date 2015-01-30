package com.mridasoft.learning.guava.eventbus;

import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Purchaser extends Thread {
	
	private static final Logger	LOG	= LoggerFactory.getLogger(Purchaser.class);
	
	private final int threadId;
	private final PruchaseComponent purchaseService;
	
	//100 is resulting in 6000 messages
	//1 makes it 599759
	private final Long SLEEP_TIME = 1L;
	
	private long itemNo;
	public volatile boolean keepRunning=true; 
	
	public Purchaser(int id, PruchaseComponent purchaseService) {
		this.threadId = id; 
		this.purchaseService = purchaseService;
	}
	
	@Override
	public void run() {
		while(keepRunning) {
			String itemId = threadId+"-"+itemNo++;
			LOG.debug("purchasing new item {} ",itemId);
			purchaseService.itemPurchased(itemId, 10.0);
			try {
				TimeUnit.MILLISECONDS.sleep(SLEEP_TIME);
			} catch (InterruptedException e) {
				LOG.error("Interrupted by some thread");
			}
		}
	}
	
	
	public long getNumProduced() {
		return itemNo;
	}
}
