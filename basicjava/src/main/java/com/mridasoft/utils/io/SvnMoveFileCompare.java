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

public class SvnMoveFileCompare {

	private String src, dest, fileExt = ".java", base;

	public SvnMoveFileCompare() {

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

	public void setBase(String base) {
		this.base = base;
	}

	public String getBase() {
		return base;
	}

	public void execute() {

		System.out.println("Starting fie comparision in directories " + src
				+ " " + dest);

		File srcDir = new File(src);
		if (!srcDir.isDirectory())
			throw new IllegalArgumentException("Not a directory - " + src);
		File destDir = new File(dest);
		if (!destDir.isDirectory())
			throw new IllegalArgumentException("Not a directory - " + dest);

		HashMap<String, Path> srcJava = MridaFileUtils.listFiles(src, fileExt,
				"target", ".svn", ".settings");
		System.out.println(srcJava.size() + " files found");
		HashMap<String, Path> destJava = MridaFileUtils.listFiles(dest,
				fileExt, "target", ".svn", ".settings");
		System.out.println(destJava.size() + " files found");

		if (srcJava == null || destJava == null || srcJava.isEmpty()
				|| destJava.isEmpty()) {
			System.out
					.println("atleast one of the directory got no mathcing files - exiting");
			return;
		}

		System.out.println("count of files in src-" + srcJava.size());
		System.out.println("count of files in dest-" + destJava.size());

		Path srcBasePath = Paths.get(src);
		Path destBasePath = Paths.get(dest);
		Path basePath = Paths.get(base);

		Iterator<String> srcJavaItr = srcJava.keySet().iterator();
		while (srcJavaItr.hasNext()) {
			try {
				String file = srcJavaItr.next();

				if ("package-info.java".equals(file))
					continue;

				Path srcJavaPath = srcJava.get(file);
				String srcContent = FileUtils.readFileToString(srcJavaPath
						.toFile());

				if (destJava.containsKey(file)) {

					Path destJavaPath = destJava.get(file);

					srcContent = FileUtils.readFileToString(srcJavaPath
							.toFile());

					String destContent = FileUtils
							.readFileToString(destJavaPath.toFile());
					if (!srcContent.equals(destContent)) {
						if (!srcContent.contains("com.vaadin"))
							logSvnMove(basePath, srcBasePath, destBasePath,
									srcJavaPath,true);
					}
				} else {
					if (srcContent.contains("com.vaadin"))
						continue;

					logSvnMove(basePath, srcBasePath, destBasePath, srcJavaPath,false);

				}

			} catch (Exception e) {

			}
		}
	}

	private void logSvnMove(Path baseDir, Path srcBase, Path destBase, Path src, boolean replace) {
		
		String fn = src.toString(); 
		if(fn.contains("Panel") || fn.contains("Screen"))
			return;

		Path relativeSrc = srcBase.relativize(src);

		Path destPath = destBase.resolve(relativeSrc);

		Path destDir = destPath.toFile().getParentFile().toPath();
		File parent = destPath.toFile().getParentFile();
		
		if (!parent.exists())
			System.out.println("svn mkdir "+ destDir.toString());

		if(replace)
			System.out.println("svn delete " + destPath);
		System.out.println("svn copy " + src + " " + destDir);

	}

	public static void main(String[] args) {
		SvnMoveFileCompare operation = new SvnMoveFileCompare();

		operation.setSrc("C:\\workspace\\mch_1.1.0\\orchestrate_v2\\ui\\src\\main\\java\\");
		operation.setDest("C:\\workspace\\cmf_mch_1.2.0\\mch-parent\\ui7\\src\\main\\java\\");
		operation.setBase("C:\\workspace\\cmf_mch_1.2.0\\mch-parent\\");
		operation.setFileExt(".java");
		
		
		
		/*operation.setSrc("C:\\workspace\\mch_1.1.0\\orchestrate_v2\\ui\\src\\main\\resources\\");
		operation.setDest("C:\\workspace\\cmf_mch_1.2.0\\mch-parent\\ui7\\src\\main\\resources\\");
		operation.setBase("C:\\workspace\\cmf_mch_1.2.0\\mch-parent\\");
		operation.setFileExt(".xml");*/
		
		
		operation.execute();
	}

}
