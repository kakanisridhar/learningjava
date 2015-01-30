package com.mridasoft.learning.guava;

import com.google.common.util.concurrent.AbstractIdleService;

public class MyService extends AbstractIdleService {
	
	private String name;
	
	public MyService(String servName) {
		this.name = servName;
	}
	
	@Override
	protected void startUp() throws Exception {
		System.out.println(name+" startup");
	}

	@Override
	protected void shutDown() throws Exception {
		System.out.println(name + " shutdown");
	}

}
