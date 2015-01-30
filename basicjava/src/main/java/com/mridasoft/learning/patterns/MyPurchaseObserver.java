package com.mridasoft.learning.patterns;

import java.util.Observable;
import java.util.Observer;

public class MyPurchaseObserver implements Observer {

	@Override
	public void update(Observable o, Object arg) {
		System.out.println("got notification");
	}

}
