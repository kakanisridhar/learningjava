package com.mridasoft.learning.guava.eventbus;

import com.google.common.eventbus.EventBus;

public class PruchaseComponent {
	
	private EventBus internalBus; 
	
	public void init(final EventBus bus) {
		internalBus = bus;
	}
	
	void itemPurchased(String itemId,double price) {
		internalBus.post(new PurchaseEvent(itemId,1,price));	
	}

}
