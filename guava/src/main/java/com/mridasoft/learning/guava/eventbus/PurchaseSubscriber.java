package com.mridasoft.learning.guava.eventbus;

import java.util.concurrent.atomic.AtomicLong;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;

public class PurchaseSubscriber {
	
	private static final Logger	LOG	= LoggerFactory.getLogger(PurchaseSubscriber.class);
	
	private AtomicLong msgCount = new AtomicLong();
	
	public void init(final EventBus bus) {
		LOG.debug("registering with event bus");
		bus.register(this);
	}

	//this should be public void with @Subscribe  
	@Subscribe
	public void onPurchase(PurchaseEvent e) {
		LOG.debug("{} - Some one purchased something-{}",Thread.currentThread().getName(),e.toString());
		msgCount.incrementAndGet();
	}

	public Long getMsgCount() {
		return msgCount.get();
	}
	
	
}
