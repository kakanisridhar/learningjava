package com.mridasoft.learning.nio;

import java.nio.charset.Charset;
import java.util.SortedMap;

public class Charset1 
{
	public static void main(String[] args) {
		
		SortedMap<String, Charset>  charsets = Charset.availableCharsets();
		System.out.println(System.getProperty("file.encoding"));
		
		/*for (String charset : charsets.keySet()) {
			System.out.println(charset);
			System.out.println(charsets.get(charset));
		}*/
	}
}
	