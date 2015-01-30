package com.mridasoft.utils.io;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;

import com.google.common.collect.HashMultimap;

public class FolderCompare {

	private String src, dest, fileExt = ".java";

	public FolderCompare() {

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
			Set<Path> files = srcJava.get(file);
			
			if (destJava.containsKey(file)) {
				//System.err.println("file exists "+file);
			}
			else {
				System.out.println(" file does not exist in des - " + file);
			}
		}
	}

	
	

	public static void main(String[] args) {
		FolderCompare operation = new FolderCompare();
		operation.setSrc("C:\\workspace\\cmf_mch_1.1.0\\mch-parent\\dist\\target\\mch-1.1.0.2273\\lib\\");
		operation.setDest("C:\\Users\\srkakani\\Downloads\\mch-1.1.0.2271\\lib\\");
		operation.setFileExt(".jar");
		operation.execute();
		
	}

}
