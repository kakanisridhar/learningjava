package com.mridasoft.utils.io;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;

import com.google.common.collect.Sets;

public class AnalyzeLog {
	
	private static String getClassName(String text) {
		//System.out.println(text);
		return text.substring(text.indexOf("("), text.indexOf(")"));
	}
	
	public static void main(String[] args) {
		
		String START = "multithreadProcessMessage - start";
		String STOP = "multithreadProcessMessage - end";
		String FILE = "C:\\workspace\\ov2\\OSIT\\antoutput.log\\";
		
		int started = 0, ended = 0;
		
		try {
			
			List<String> lines = FileUtils.readLines(new File(FILE));
			for (String string : lines) {
				if(string.endsWith(START)){
					++started;
				} else if(string.endsWith(STOP)) {
					++ended;
				}
			}
			
			if(started != ended)
				System.out.println("started and stopped are different sizes "+started+" "+ended);
			else
				System.out.println("started and ended are same "+started+" "+ended);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
