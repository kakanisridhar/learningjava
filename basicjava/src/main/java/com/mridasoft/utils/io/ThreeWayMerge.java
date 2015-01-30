package com.mridasoft.utils.io;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;

import com.google.common.collect.HashMultimap;

public class ThreeWayMerge {

	private String src1,src2,dest, fileExt = ".java";

	public ThreeWayMerge() {

	}

	public String getSrc1() {
		return src1;
	}

	public void setSrc1(String src) {
		this.src1 = src;
	}
	
	public String getSrc2() {
		return src2;
	}

	public void setSrc2(String src) {
		this.src2 = src;
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
		
		
		HashMap<String, Path> src1Java = MridaFileUtils.listFiles(src1,fileExt,"target");
		HashMap<String, Path> src2Java = MridaFileUtils.listFiles(src2,fileExt,"target");
		
		Path srcPath = Paths.get(src1);
		
		URI base = srcPath.toUri();
		
		Iterator<String> srcJavaItr = src1Java.keySet().iterator();
		while (srcJavaItr.hasNext()) {
			String file = srcJavaItr.next();
			if("log4j.properties".equals(file) || "GitKeep.java".equals(file))
				continue;
			
			Path filePathSrc1 = src1Java.get(file);
			Path filePathSrc2 = src2Java.get(file);
			
			if(filePathSrc2==null) continue;
			
			URI absolute =  filePathSrc1.toUri();
			
			URI relative = base.relativize(absolute);
			
			Path relPath =  Paths.get(dest, relative.toString());
			
			File parent =  relPath.toFile().getParentFile();
			if(!parent.exists())
				parent.mkdirs();
			
			Path finalPath = relPath.toFile().getParentFile().toPath();
			
			//System.out.println(finalPath);
			
			System.out.println("svn move "+ filePathSrc2 + " "+ finalPath + " --force");
			
		}
	}

	public static void main(String[] args) {
		ThreeWayMerge operation = new ThreeWayMerge();
		
		operation.setSrc1("D:\\GIT\\ov2\\orch\\orch-components\\src\\main");
		operation.setSrc2("C:\\workspace\\ov2\\OrchestrateV2\\src\\");
		operation.setDest("C:\\workspace\\ov2\\OrchestrateV2\\components\\src\\main");
		operation.setFileExt("*");
		operation.execute();
		
		System.out.println("****TESTS***");
		
		operation.setSrc1("D:\\GIT\\ov2\\orch\\orch-components\\src\\test");
		operation.setSrc2("C:\\workspace\\ov2\\OrchestrateV2\\src\\");
		operation.setDest("C:\\workspace\\ov2\\OrchestrateV2\\components\\src\\test");
		operation.setFileExt("*");
		operation.execute();
		
	}

}
