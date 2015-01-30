package com.mridasoft.learning.guava;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import com.google.common.util.concurrent.*;
import com.google.common.util.concurrent.Service.Listener;
import com.google.common.util.concurrent.Service.State;

public class MyServer {
	
	public static void main(String[] args) {
		
	     Set<Service> services = new HashSet<Service>();
	     services.add(new MyService("Service A version 1"));
	     
	     final ServiceManager manager = new ServiceManager(services);
	     
	     Runtime.getRuntime().addShutdownHook(new Thread() {
	       public void run() {
	         try {
	           manager.stopAsync().awaitStopped(5, TimeUnit.SECONDS);
	         } catch (TimeoutException timeout) {
	         }
	       }
	     });
	     
	     manager.startAsync();  // start all the services asynchronously
	     
	   }

}
