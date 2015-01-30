package com.mridasoft.utils.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.HashMap;

import org.apache.commons.io.FileUtils;

import com.google.common.collect.HashMultimap;


/**
 * use apache commons io.
 * This is only for learning purpose  
 */
public class MridaFileUtils 
{
	public static void fileCopy(File in, File out) throws IOException {
		FileChannel inChannel = new FileInputStream(in).getChannel();
		FileChannel outChannel = new FileOutputStream(out).getChannel();
		try {
			// inChannel.transferTo(0, inChannel.size(), outChannel); //
			// original -- apparently has trouble copying large files on Windows

			// magic number for Windows, 64Mb - 32Kb)
			int maxCount = (64 * 1024 * 1024) - (32 * 1024);
			long size = inChannel.size();
			long position = 0;
			while (position < size) {
				position += inChannel
						.transferTo(position, maxCount, outChannel);
			}
		} finally {
			if (inChannel != null) {
				inChannel.close();
			}
			if (outChannel != null) {
				outChannel.close();
			}
		}
	}
	
	public static String readFile(String path) throws IOException {
		  FileInputStream stream = new FileInputStream(new File(path));
		  try {
		    FileChannel fc = stream.getChannel();
		    MappedByteBuffer bb = fc.map(FileChannel.MapMode.READ_ONLY, 0, fc.size());
		    /* Instead of using default, pass in a decoder. */
		    return Charset.defaultCharset().decode(bb).toString();
		  }
		  finally {
		    stream.close();
		  }
	}

	public static void writeFile(String path,String content) throws IOException {
		  FileOutputStream stream = new FileOutputStream(new File(path));
		  try {
		    FileChannel fc = stream.getChannel();
		    ByteBuffer bb =  ByteBuffer.allocate(content.length());
		    bb.put(content.getBytes());
		    bb.flip();
		    fc.write(bb);
		  }
		  finally {
		    stream.close();
		  }
	}
	
	public static HashMap<String, Path> listFiles(final String path,final String pattern, final String ... dirExcludes){
		
		try {
			
			final HashMap<String, Path> files =  new HashMap<>();
		
			Path start = Paths.get(path);
			Files.walkFileTree(start, new SimpleFileVisitor<Path>() {
				@Override
				public FileVisitResult visitFile(Path file,
						BasicFileAttributes attrs) throws IOException {
					
					String fname = file.getFileName().toString();
					
					if (fname.endsWith(pattern) || "*".equalsIgnoreCase(pattern))
						files.put(fname, file);
					
					return FileVisitResult.CONTINUE;
				}
	
				@Override
				public FileVisitResult preVisitDirectory(Path dir,
						BasicFileAttributes attrs) throws IOException {
	
					for(String dirExclude : dirExcludes)	
						if (dir.endsWith(dirExclude))
							return FileVisitResult.SKIP_SUBTREE;
	
					return FileVisitResult.CONTINUE;
				}
				
			});
			
		   return files;
		} catch(Exception e) {
			e.printStackTrace();
		}
	 
		return null;
		
	}
	
	public static HashMultimap<String, Path> listFilesByName(final String path,final String pattern, final String... dirExcludes){
		
		try {
			
			final HashMultimap<String, Path> files =  HashMultimap.create();
		
			Path start = Paths.get(path);
			Files.walkFileTree(start, new SimpleFileVisitor<Path>() {
				@Override
				public FileVisitResult visitFile(Path file,
						BasicFileAttributes attrs) throws IOException {
					
					String fname = file.getFileName().toString();
					
					if (fname.endsWith(pattern)) {
						files.put(fname, file);
					} else {
						//System.out.println(file+ " does not match required extension " + pattern);
					}
					return FileVisitResult.CONTINUE;
				}
	
				@Override
				public FileVisitResult preVisitDirectory(Path dir,
						BasicFileAttributes attrs) throws IOException {
	
					for(String dirExclude : dirExcludes )
						if (dir.endsWith(dirExclude))
							return FileVisitResult.SKIP_SUBTREE;
	
					return FileVisitResult.CONTINUE;
				}
				
			});
			
		   return files;
		} catch(Exception e) {
			e.printStackTrace();
		}
	 
		return null;
		
	}
	

}
