package com.mridasoft.learning.streams;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class Flatmap {
	
	public static void main(String[] args) {
		String[] names = {"sreedhara", "kakani"};
		
		List<?> op = Arrays.stream(names)
					 .map(n -> n.split(""))
					 .flatMap(Arrays::stream)
					 .distinct()
					 .collect(toList());
		
		op.stream().forEach(o -> System.out.println(o));
	}

}
