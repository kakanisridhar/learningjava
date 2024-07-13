package com.mridasoft.learning.basic;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class BinaryWriter {
	
	static void writeToFile(Object o, File f) {
		ObjectOutputStream oStream;
		try {
			oStream = new ObjectOutputStream(new FileOutputStream(f));
			oStream.writeObject(o);
			oStream.flush();
			oStream.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
