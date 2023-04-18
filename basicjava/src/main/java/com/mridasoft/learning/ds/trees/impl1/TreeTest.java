package com.mridasoft.learning.ds.trees.impl1;


public class TreeTest {
	
	public static void main(String[] args) {
		
		DefaultTree tree = new DefaultTree("Menu");
		
		tree.putIfAbsent(0, "RefData/Country");
		tree.putIfAbsent(1, "RefData/Currency");
		tree.putIfAbsent(0, "RefData");
		
		tree.putIfAbsent(0, "RefData1/Country");
		tree.putIfAbsent(1, "RefData1/Currency");
		tree.putIfAbsent(1, "RefData1");
		
		tree.putIfAbsent(0, "MarketData/Equity");
		tree.putIfAbsent(1, "MarketData/Fx");
		tree.putIfAbsent(2, "MarketData/FI");
		tree.putIfAbsent(2, "MarketData");
		
		System.out.println( tree.toString() );
		
	}

}
