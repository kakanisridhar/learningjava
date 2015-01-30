package com.mridasoft.utils.io;

import java.io.File;

import org.apache.commons.io.filefilter.FileFileFilter;

public class TempUtil {

	public static void main(String[] args) {
		String prefix = "mvn install:install-file -DgroupId=com.ibm -Dversion=7.0.1.4 -Dpackaging=jar";
		
		String path = "C:\\workspace\\ov2\\OrchestrateV2\\libs\\runtime\\external\\lbg\\ibm_mq\\";
		
		 File dir = new File(path);
		 String[] files = dir.list( FileFileFilter.FILE );
		 for ( int i = 0; i < files.length; i++ ) {
		     String jar = files[i];
		     System.out.println(prefix + String.format(" -Dfile=%1$s -DartifactId=%2$s", jar,jar.replaceFirst("com.ibm.", "").replaceAll(".jar", "")));
		 }
		 
		
	}
	
}
