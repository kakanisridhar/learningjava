package com.mridasoft.utils.io;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;

import com.google.common.collect.HashMultimap;

public class Merge {

	private String src, dest, fileExt = ".java";

	public Merge() {

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
		
		
		List<String> lines = null;
		try {
			lines = FileUtils.readLines(new File("C:\\workspace\\ov21.7\\OrchestrateV2\\orchmerge.txt"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		HashMultimap<String, Path> srcJava =  HashMultimap.create();
		HashMultimap<String, Path> destJava = MridaFileUtils.listFilesByName(dest,fileExt, ".m2");
		
		for (Iterator iterator = lines.iterator(); iterator.hasNext();) {
			String string = (String) iterator.next();
			if(string.endsWith(fileExt)) {
				//System.out.println(string);
				Path fpath = Paths.get(getSrc(), string);
				File f = fpath.toFile();
				if(f.exists()) {
					srcJava.put(f.getName(), fpath);
				}
			}
		}
		
		Iterator<String> srcJavaItr = srcJava.keySet().iterator();
		while (srcJavaItr.hasNext()) {
			String file = srcJavaItr.next();
			if( "package-info.java".equals(file) ||
				"log4j.properties".equals(file) || 
				"GitKeep.java".equals(file) ||
				"DBUtils.java".equals(file))
				continue;
			Set<Path> files = srcJava.get(file);
			
			if (destJava.containsKey(file)) {
				if(files.size() != 	destJava.get(file).size())
					System.out.println("szies different for "+ file  +" src size=" + files.size() + " dest size="+destJava.get(file).size());
				else
					compareFilesAndReplace(files, destJava.get(file));
			}
			else {
				System.out.println(" file does not exist in des - " + file);
			}
		}
	}

	void compareFilesAndReplace(Set<Path> src, Set<Path> dest) {

		for (Path srcPath : src) {
			
			try {
				
				String srcContent = FileUtils.readFileToString(srcPath.toFile());

				for (Path destPath : dest) {
					String destContent = FileUtils.readFileToString(destPath.toFile());
					if (!srcContent.equals(destContent)) {
						System.out.println(srcPath.toString() + "," + destPath.toString());
						//FileUtils.copyFile(srcPath.toFile(), destPath.toFile());
					}
				}

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	

	public static void main(String[] args) {
		Merge operation = new Merge();
		
		operation.setSrc("C:\\workspace\\ov2\\OV21.6\\");
		operation.setDest("C:\\workspace\\ov2\\merge_1.6_1.7\\");
		operation.setFileExt(".java");
		operation.execute();
		
	}

}
