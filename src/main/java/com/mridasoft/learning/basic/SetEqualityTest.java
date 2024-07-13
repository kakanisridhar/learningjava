package com.mridasoft.learning.basic;

import java.util.HashSet;
import java.util.Set;

public class SetEqualityTest {

	public static void main(String[] args) {
		Set<String> set1 = new HashSet<String>();
		Set<String> set2 = new HashSet<String>();
		
		set1.add("ClassID");
		set2.add("ClassID1");
		
		System.out.println(set1.equals(set2));
	}
}
