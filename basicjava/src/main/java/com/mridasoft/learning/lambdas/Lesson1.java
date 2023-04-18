package com.mridasoft.learning.lambdas;

import java.util.Arrays;
import java.util.function.Predicate;

public class Lesson1 {
	
	public static void main(String[] args) {
		
		Predicate<String> predRef = S -> S!=null && !S.isEmpty();

		String[] someStrings = {"",null,"!","\n"};
		
		Arrays.stream(someStrings).filter(predRef).forEach(S -> System.out.println(S));
		
		System.out.println("done");
	}

}
