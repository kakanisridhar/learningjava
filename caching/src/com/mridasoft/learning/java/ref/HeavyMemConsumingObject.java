package com.mridasoft.learning.java.ref;

public class HeavyMemConsumingObject {
	
	private int[][] graph;
	private String name;
	
	//this is palin stupid...but let me see if i ever gets GCed
	private HeavyMemConsumingObject myRef;
	
	public HeavyMemConsumingObject(final String name, final int e, final int v ) {
		this.name = name;
		graph = new int[e][v];
	}
	
	public void printSize() {
		System.out.println(graph.length);
	}
	
	@Override
	protected void finalize() throws Throwable {
		System.out.println(name+" Object going out of memory");
		myRef = this;
		myRef.printSize();
	}

}
