package com.mridasoft.utils.io;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Sets;

public class AnalyzeSvnDiff {
	
	public static void main(String[] args) {
		
		String START = "Index: ";
		String FILE = "C:\\workspace\\ov21.7\\OrchestrateV2\\orchdiff.diff";
		
		HashMultimap<String, String> filesByExtension =  HashMultimap.create(); 
		
		try {
			List<String> lines = FileUtils.readLines(new File(FILE));
			
			int len = START.length();
			for (String string : lines) {
				if(string.startsWith(START)){
					String ext = string.substring(string.lastIndexOf(".")+1);
					filesByExtension.put(ext, string.substring(len));
				}
			}
			
			Iterator<String> filesByExtensionItr = filesByExtension.keySet().iterator();
			while (filesByExtensionItr.hasNext()) {
			
				String ext =filesByExtensionItr.next();
				Set<String> files = filesByExtension.get(ext);
				
				System.out.println(ext);
				
				for(String file : files)
					System.out.println(file);
				
				System.out.println("");
			}
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
