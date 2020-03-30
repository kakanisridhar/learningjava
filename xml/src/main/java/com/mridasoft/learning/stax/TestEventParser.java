package com.mridasoft.learning.stax;

import java.util.List;

public class TestEventParser {
	
	public static void main(String[] args) {
		XmlEventParser read = new XmlEventParser();
		
		String fileFromClassPath = TestEventParser.class.getResource("/xml1.xml").getFile();
		List<Item> readConfig = read.readConfig(fileFromClassPath);
		for (Item item : readConfig) {
			System.out.println(item);
		}
	}

}
