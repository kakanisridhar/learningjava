package com.mridasoft.learning.guava.eventbus;

public class PurchaseEvent {
	
	private final String itemId;
	private final double quantity;
	private final double price;
	
	public PurchaseEvent(String itemId,double quantity, double price) {
		this.itemId = itemId;
		this.quantity = quantity;
		this.price = price;
	}

	public String getItemId() {
		return itemId;
	}

	public double getPrice() {
		return price;
	}
	
	public double getQuantity() {
		return quantity;
	}

	@Override
	public String toString() {
		return "PurchaseEvent [itemId:" + itemId + ", quantity:" + quantity
				+ ", price:" + price + "]";
	}
	
	

}
