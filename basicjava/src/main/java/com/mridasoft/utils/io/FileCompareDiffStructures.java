package com.mridasoft.utils.io;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;

import com.google.common.collect.HashMultimap;

public class FileCompareDiffStructures {

	private String src, dest, fileExt = ".java";

	public FileCompareDiffStructures() {

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
			if("package-info.java".equals(file) || "log4j.properties".equals(file) || "GitKeep.java".equals(file)||
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
		FileCompareDiffStructures operation = new FileCompareDiffStructures();
		
		/*operation.setSrc("C:\\workspace\\ov2\\OrchestrateV2\\");
		operation.setDest("D:\\GIT\\ov2\\orch");
		operation.setFileExt(".java");
		operation.execute();*/
		
		operation.setSrc("C:\\workspace\\cmf_mch_1.2.0\\mch-parent\\ui\\src\\main\\java\\");
		operation.setDest("C:\\workspace\\cmf_mch_1.2.0\\mch-parent\\ui7\\src\\main\\java\\");
		operation.setFileExt(".java");
		operation.execute();
		
		/*operation.setSrc("D:\\GIT\\ov2\\orch\\orch-common\\src\\");
		operation.setDest("C:\\workspace\\ov2\\orchestrate-parent\\common\\src\\");
		operation.setFileExt(".java");
		operation.execute();*/
		
		
		
		/*operation.setSrc("C:\\GIT\\orchestrate\\orch\\");
		operation.setDest("D:\\GIT\\ov2\\orch");
		operation.setFileExt(".xsl");
		operation.execute();*/

		
		
	}

}
