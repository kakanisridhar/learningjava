package com.mridasoft.learning.patterns;

public class ObserverDemo {
	
	public static void main(String[] args) {
		ObservableItem car = new ObservableItem();
		MyPurchaseObserver carPurchaseListener = new MyPurchaseObserver();
		car.addObserver(carPurchaseListener);
		car.itemPurchased();
		
		System.out.println("*****************Thats All Folks**********");
	}

}
