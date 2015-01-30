package com.mridasoft.learning.guava.eventbus;

import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.eventbus.AsyncEventBus;
import com.google.common.util.concurrent.ThreadFactoryBuilder;

public class ApplicationASync {
	private static final Logger	LOG	= LoggerFactory.getLogger(ApplicationASync.class);
	
	public static void main(String[] args) {
		
		//http://www.javapractices.com/topic/TopicAction.do?Id=56
		UUID instance = UUID.randomUUID();
		
		ThreadFactoryBuilder subThreadBuilder = new ThreadFactoryBuilder().
													setNameFormat("purchase-subscriber-pool-%d")
													.setDaemon(true);
		
		ExecutorService subscThreads =  Executors.newFixedThreadPool(1,subThreadBuilder.build());
		
		AsyncEventBus APP_BUS = new AsyncEventBus(instance.toString(),subscThreads);
		
		PurchaseSubscriber eventListener = new PurchaseSubscriber();
		eventListener.init(APP_BUS);
		
		final PruchaseComponent publisher = new PruchaseComponent();
		publisher.init(APP_BUS);
		
		final int THREADS = 10; 
		
		ThreadFactoryBuilder builder = new ThreadFactoryBuilder().setNameFormat("purchase-component-pool-%d");
		
		ExecutorService threads =  Executors.newFixedThreadPool(THREADS,builder.build());
		
		Purchaser[] producers = new Purchaser[THREADS];
		
		for(int i=0;i<THREADS;i++) {
			producers[i] = new Purchaser(i,publisher);
			threads.submit(producers[i]);
		}
		
		try {
			TimeUnit.MINUTES.sleep(1);
		} catch (InterruptedException e) {
			
		}
		LOG.info("**************************************************");
		threads.shutdown();
		
		for(int i=0;i<THREADS;i++) {
			producers[i].keepRunning = false;
		}
		
		long total = 0;
		
		for(int i=0;i<THREADS;i++) {
			total += producers[i].getNumProduced();
		}
		
		LOG.info("totals produced - {} , consumed- {}",total,eventListener.getMsgCount());
		
	}

}
