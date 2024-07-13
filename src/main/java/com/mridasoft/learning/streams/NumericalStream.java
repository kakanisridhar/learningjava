package com.mridasoft.learning.streams;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class NumericalStream {

	public static void main(String[] args) {
		 // numeric ranges
        IntStream evenNumbers = IntStream.rangeClosed(1, 100)
                                 .filter(n -> n % 2 == 0);

        System.out.println(evenNumbers.count());

        Stream<int[]> pythagoreanTriples =
               IntStream.rangeClosed(1, 100).boxed()
                        .flatMap(a -> IntStream.rangeClosed(a, 100)
                                               .filter(b -> Math.sqrt(a*a + b*b) % 1 == 0).boxed()
                                               .map(b -> new int[]{a, b, (int) Math.sqrt(a * a + b * b)}));       

        pythagoreanTriples.forEach(t -> System.out.println(t[0] + ", " + t[1] + ", " + t[2])); 

	}
	
}
