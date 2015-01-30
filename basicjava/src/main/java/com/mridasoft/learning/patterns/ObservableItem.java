package com.mridasoft.learning.patterns;

import java.util.Observable;

public class ObservableItem extends Observable {
	
	/*@Override
	public synchronized boolean hasChanged() {
		return true;
	}
	
	@Override
	protected synchronized void clearChanged() {
		//do nothing
	}*/
	
	public void itemPurchased() {
		this.setChanged();
		notifyObservers(this);
	}

}
