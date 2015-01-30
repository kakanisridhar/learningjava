package com.mridasoft.utils.io;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.FileFileFilter;

import com.google.common.collect.HashMultimap;

public class FileCompare {

	private String src, dest, fileExt = ".java";

	public FileCompare() {

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
		
		HashMap<String, Path> srcJava = MridaFileUtils.listFiles(src,fileExt, "target", ".svn", ".settings");
		System.out.println(srcJava.size()+" files found");
		HashMap<String, Path> destJava = MridaFileUtils.listFiles(dest,fileExt, "target", ".svn", ".settings");
		System.out.println(destJava.size()+" files found");
		
		if(srcJava==null || destJava ==null || srcJava.isEmpty() || destJava.isEmpty()) {
			System.out.println("atleast one of the directory got no mathcing files - exiting");
			return;
		}
		
		System.out.println("count of files in src-"+srcJava.size());
		System.out.println("count of files in dest-"+destJava.size());
		
		URI srcBase = Paths.get(src).toUri();

		Iterator<String> srcJavaItr = srcJava.keySet().iterator();
		while (srcJavaItr.hasNext()) {
			String file = srcJavaItr.next();
			
			if("package-info.java".equals(file))
				continue;
				
			Path files = srcJava.get(file);
			
			if (destJava.containsKey(file)) {
				
				compareFilesAndReplace(files, destJava.get(file));
				
			}
			else {
				//System.out.println(" file does not exist in des - " + file);
				
				try {
					String srcContent = FileUtils.readFileToString(files.toFile());
					if(srcContent.contains("com.vaadin"))
						continue;
				} catch (IOException e) {
				}
				
				URI absolute =  files.toUri();
				
				URI relative = srcBase.relativize(absolute);
				
				Path destPath =  Paths.get(dest, relative.toString());
				
				File parent =  destPath.toFile().getParentFile();
				if(!parent.exists())
					parent.mkdirs();
				
				Path finalPath = destPath.toFile().getParentFile().toPath();
				
				System.out.println("svn move "+ files + " "+ finalPath + " --force");

			}
		}
	}

	void compareFilesAndReplace(Path src, Path dest) {
				
		String srcContent;
		try {
			srcContent = FileUtils.readFileToString(src.toFile());
		
			String destContent = FileUtils.readFileToString(dest.toFile());
			if (!srcContent.equals(destContent)) {
				System.err.println(src.toString() + "," + dest.toString());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}	
		
	}
	

	public static void main(String[] args) {
		FileCompare operation = new FileCompare();
		operation.setSrc("C:\\workspace\\mch_1.1.0\\orchestrate_v2\\ui\\src\\main\\java\\");
		operation.setDest("C:\\workspace\\cmf_mch_1.2.0\\mch-parent\\ui7\\src\\main\\java\\");
		operation.setFileExt(".java");
		operation.execute();
	}

}
