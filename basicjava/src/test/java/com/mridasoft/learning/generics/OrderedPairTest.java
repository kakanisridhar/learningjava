package com.mridasoft.learning.generics;


import static org.junit.Assert.*;

import org.junit.Test;

public class OrderedPairTest {
	
	@Test
	public void testEquality() {
		
		OrderedPair<Integer,Integer> intPair1 = OrderedPair.of(1, 10000);
		OrderedPair<Integer,Integer> intPair2 = OrderedPair.of(1, 10000);
		
		//unless equals is implemented this will fail
		assertEquals(intPair1,intPair2);
	}
	
	
	@Test
	public void testClassEquality() {
		
		OrderedPair<Integer,Integer> intPair1 = OrderedPair.of(1, 10000);
		OrderedPair<Integer,String> stringPair1 = OrderedPair.of(1, "sreedhara");
		
		//this is obvious in case of java
		assertEquals(intPair1.getClass(),stringPair1.getClass());
	}
	
	@Test
	public void testWitRawTypes() {
		
		OrderedPair<Integer,Integer> intPair1 = OrderedPair.of(1, 10000);
		
		OrderedPair rawPair1 = new OrderedPair();
		rawPair1.setKey(1);
		rawPair1.setValue(10000);
		
		assertEquals(intPair1, rawPair1);
		
	}	
	
	
}
