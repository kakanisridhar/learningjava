 package com.mridasoft.commons.utils;
 
 import java.io.IOException;
 import java.nio.file.FileVisitResult;
 import java.nio.file.Files;
 import java.nio.file.Path;
 import java.nio.file.SimpleFileVisitor;
 import java.nio.file.attribute.BasicFileAttributes;
 
 public class DeletingFileVisitor extends SimpleFileVisitor<Path>
 {
   public FileVisitResult visitFile(Path file, BasicFileAttributes attributes)
     throws IOException
   {
     if (attributes.isRegularFile()) {
     Files.delete(file);
     }
     return FileVisitResult.CONTINUE;
   }
 
   public FileVisitResult postVisitDirectory(Path directory, IOException ioe) throws IOException
   {
     Files.delete(directory);
     return FileVisitResult.CONTINUE;
   }
 
   public FileVisitResult visitFileFailed(Path file, IOException ioe) throws IOException
   {
     return FileVisitResult.CONTINUE;
   }
 }

