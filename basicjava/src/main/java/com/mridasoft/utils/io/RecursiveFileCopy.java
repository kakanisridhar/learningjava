package com.mridasoft.utils.io;

import java.io.File;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Collection;
import java.util.Iterator;


public class RecursiveFileCopy 
{
	private String src,dest,fileNamePattern;
	
	public RecursiveFileCopy() 
	{
		
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
	
	public String getFileNamePattern() {
		return fileNamePattern;
	}

	public void setFileNamePattern(String fileNamePattern) {
		this.fileNamePattern = fileNamePattern;
	}

	public void execute()
	{
		try
		{
			File srcDir = new File(src);
			if(!srcDir.isDirectory()) throw new IllegalArgumentException("Not a directory - " + src);
			File destDir = new File(dest);
			if(!destDir.isDirectory()) throw new IllegalArgumentException("Not a directory - " + dest);
			
			Path start = Paths.get(src);
			Files.walkFileTree(start, new SimpleFileVisitor<Path>() {
				@Override
				public FileVisitResult visitFile(Path file, BasicFileAttributes attrs)	throws IOException
				{
					System.out.println(file);
					if(file.endsWith(fileNamePattern)) 
					{
						String destPath = file.toString().replace(src, dest);
						System.out.println(destPath);
						
						File destFile = new File(destPath);
						if(destFile.exists()) return FileVisitResult.CONTINUE;
						System.out.println("non existing in dest"+destFile.getName());
						//MridaFileUtils.fileCopy(file.toFile(), destFile);
					}
					return FileVisitResult.CONTINUE;
				}
				@Override
				public FileVisitResult preVisitDirectory(Path dir,	BasicFileAttributes attrs) throws IOException {
				
					if(dir.endsWith(".m2"))
						return FileVisitResult.SKIP_SUBTREE;
					
					return FileVisitResult.CONTINUE;
				}

			});
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		RecursiveFileCopy operation = new RecursiveFileCopy();
		/*operation.setSrc("C:\\GIT\\TO");
		operation.setDest("C:\\GIT\\dev-3.2.10");
		operation.setFileNamePattern(".classpath");
		operation.execute();
		operation.setFileNamePattern(".project");
		operation.execute();*/
		
		operation.setSrc("C:\\Users\\srkakani\\Desktop\\ui7_partial_gloabl_hb\\ui7\\src\\main\\java\\com\\misys\\tools\\integration\\mch");
		operation.setDest("C:\\workspace\\cmf_mch_trunk\\mch-parent\\ui7\\src\\main\\java\\com\\misys\\tools\\integration\\mch");
		operation.setFileNamePattern(".java");
		operation.execute();
		
	} 

}
