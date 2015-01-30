package com.mridasoft.learning.java.ref;

import java.util.WeakHashMap;

public class BasicCacheTest {
	
	public static void main(String[] args) {
		WeakHashMap<HeavyMemConsumingObject, Double> calcReults = new WeakHashMap<>(); 
		HeavyMemConsumingObject g1 = new HeavyMemConsumingObject("TradeGraph",1000, 10000);
		HeavyMemConsumingObject g2 = new HeavyMemConsumingObject("ProductGraph",1000, 10000);
		
		calcReults.put(g1, 20.0);
		calcReults.put(g2, 20.0);
		
		System.out.println(calcReults.size());
		
		g1 = null;
		System.gc();
		System.out.println(calcReults.size());
		System.gc();
		System.out.println(calcReults.size());
	}

}
