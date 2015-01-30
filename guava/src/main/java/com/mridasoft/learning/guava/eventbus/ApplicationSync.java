package com.mridasoft.learning.guava.eventbus;

import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.eventbus.EventBus;
import com.google.common.util.concurrent.ThreadFactoryBuilder;

public class ApplicationSync {
	private static final Logger	LOG	= LoggerFactory.getLogger(ApplicationSync.class);
	
	public static void main(String[] args) {
		
		//http://www.javapractices.com/topic/TopicAction.do?Id=56
		UUID instance = UUID.randomUUID();
		EventBus APP_BUS = new EventBus(instance.toString());
		
		PurchaseSubscriber eventListener = new PurchaseSubscriber();
		eventListener.init(APP_BUS);
		
		final PruchaseComponent publisher = new PruchaseComponent();
		publisher.init(APP_BUS);
		
		/*publisher.itemPurchased("SINGLTHREADED", 10.0);
		
		try {
			TimeUnit.MINUTES.sleep(1);
		} catch (InterruptedException e) {
			
		}*/
		
		final int THREADS = 10; 
		
		ThreadFactoryBuilder builder = new ThreadFactoryBuilder().setNameFormat("purchase-component-pool-%d");
		
		ExecutorService threads =  Executors.newFixedThreadPool(THREADS,builder.build());
		
		for(int i=0;i<THREADS;i++) {
			threads.submit(new Purchaser(i,publisher));
		}
		
		try {
			TimeUnit.MINUTES.sleep(2);
		} catch (InterruptedException e) {
			
		}
		
		threads.shutdown();
	}

}
