package com.mridasoft.learning.reactor;

import reactor.core.Environment;
import reactor.core.Reactor;
import reactor.core.spec.Reactors;
import reactor.event.Event;
import reactor.event.selector.Selectors;
import reactor.function.Consumer;


public class EventBusSimple {

	public static void main(String... args) {
		
		Environment env = new Environment();
		
		Reactor reactor = Reactors.reactor()
							.env(env)
							.dispatcher(Environment.THREAD_POOL)
							.get();
		
		reactor.on(Selectors.object("test"), new Consumer<Event<String>>() {
		  @Override
		  public void accept(Event<String> ev) {
		    System.out.println("Received event with data: " + ev.getData());
		  }
		});
		
		
		reactor.notify("test", Event.wrap("Jon"));
		
		System.out.println("working?");
		
		env.shutdown();
	}
}