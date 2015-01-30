 package com.mridasoft.commons.utils;
 
 import java.io.IOException;
 import java.io.PrintStream;
 import java.nio.file.FileVisitResult;
 import java.nio.file.Files;
 import java.nio.file.Path;
 import java.nio.file.Paths;
 import java.nio.file.SimpleFileVisitor;
 import java.nio.file.attribute.BasicFileAttributes;
 
 public class CelanMavenProjects extends SimpleFileVisitor<Path>
 {
/* 13 */   private static final String[] FILES_TO_DELETE = { 
/* 14 */     ".classpath", ".project" };
 
/* 17 */   private static final String[] FOLDERS_TO_DELETE = { 
/* 18 */     "target", ".settings" };
 
/* 21 */   private DeletingFileVisitor delFileVisitor = new DeletingFileVisitor();
 
   public FileVisitResult visitFile(Path file, BasicFileAttributes attr)
   {
/* 27 */     if (attr.isRegularFile()) {
/* 28 */       for (String pattern : FILES_TO_DELETE) {
/* 29 */         if (!file.endsWith(pattern)) continue;
         try {
/* 31 */           Files.delete(file);
         } catch (Exception e) {
/* 33 */           System.err.println("failed to delete file " + file.toString());
         }
       }
     }
 
/* 38 */     return FileVisitResult.CONTINUE;
   }
 
   public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs)
     throws IOException
   {
/* 44 */     for (String pattern : FOLDERS_TO_DELETE) {
/* 45 */       if (pattern.equalsIgnoreCase(dir.getFileName().toString())) {
/* 46 */         Files.walkFileTree(dir, this.delFileVisitor);
         try {
/* 48 */           Files.delete(dir);
         } catch (Exception e) {
/* 50 */           System.err.println("failed to delete folder " + dir.toString() + " reason" + e.getClass().getName());
         }
/* 52 */         return FileVisitResult.SKIP_SUBTREE;
       }
     }
/* 55 */     return FileVisitResult.CONTINUE;
   }
 
   public FileVisitResult visitFileFailed(Path file, IOException exc)
   {
System.err.println(exc);
     return FileVisitResult.CONTINUE;
   }
 
   public static void main(String[] args) throws Exception {
     if (args.length != 1) {
       System.out.println("usage : CelanMavenProjects directory");
     System.out.println("args passed");
       String[] arrayOfString = args; int j = args.length; for (int i = 0; i < j; i++) { String s = arrayOfString[i];
       System.out.println(s); }
       return;
     }
     String dir = args[0];
   System.out.println("cleaning directory " + dir);
 
    Path startingDir = Paths.get(dir, new String[0]);
     CelanMavenProjects pf = new CelanMavenProjects();
     Files.walkFileTree(startingDir, pf);
 
     System.out.println("done");
   }
 }

