package com.mridasoft.utils.io;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;

import com.google.common.collect.HashMultimap;

public class FileCompareDuplicates {

	private String src, dest, fileExt = ".java";

	public FileCompareDuplicates() {

	}

	public String getSrc() {
		return src;
	}

	public void setSrc(String src) {
		this.src = src;
	}

	public String getDest() {
		return dest;
	}

	public void setDest(String dest) {
		this.dest = dest;
	}
	
	public String getFileExt() {
		return fileExt;
	}
	
	public void setFileExt(String fileExt) {
		this.fileExt = fileExt;
	}

	public void execute() {
		
		System.out.println("Starting fie comparision in directories "+src +" "+ dest);

		File srcDir = new File(src);
		if (!srcDir.isDirectory())
			throw new IllegalArgumentException("Not a directory - " + src);
		File destDir = new File(dest);
		if (!destDir.isDirectory())
			throw new IllegalArgumentException("Not a directory - " + dest);

		HashMultimap<String, Path> srcJava = MridaFileUtils.listFilesByName(src,fileExt, ".m2");
		HashMultimap<String, Path> destJava = MridaFileUtils.listFilesByName(dest,fileExt, ".m2");
		
		if(srcJava==null || destJava ==null || srcJava.isEmpty() || destJava.isEmpty()) {
			System.out.println("atleast one of the directory got no mathcing files - exiting");
			return;
		}

		Iterator<String> srcJavaItr = srcJava.keySet().iterator();
		while (srcJavaItr.hasNext()) {
			String file = srcJavaItr.next();
			if("package-info.java".equals(file) || "log4j.properties".equals(file) || "GitKeep.java".equals(file))
				continue;
			Set<Path> files = srcJava.get(file);
			
			if (destJava.containsKey(file)) {
				System.err.println("file exists "+file);
			}
			/*else {
				System.out.println(" file does not exist in des - " + file);
			}*/
		}
	}

	
	

	public static void main(String[] args) {
		FileCompareDuplicates operation = new FileCompareDuplicates();
		operation.setSrc("C:\\GIT\\orchestrate\\orch\\orch-components\\");
		operation.setDest("C:\\GIT\\orchestrate\\orch\\orch-server\\");
		operation.setFileExt(".xsd");
		operation.execute();

		
		
	}

}
