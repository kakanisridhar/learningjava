package com.mridasoft.learning.concurrency.intereference;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntCounter {
	
	AtomicInteger  c = new AtomicInteger(); 

    public void increment() {
        c.incrementAndGet();
    }

    public void decrement() {
        c.decrementAndGet();
    }

    public int value() {
        return c.intValue();
    }

}

