package com.mridasoft.learning.nio;

import java.nio.Buffer;
import java.nio.ByteBuffer;

public class BufferTest {

	 private static final int BSIZE = 1024;
	  public static void main(String[] args) {
	    ByteBuffer bb = ByteBuffer.allocate(BSIZE);
	    // Allocation automatically zeroes the ByteBuffer:
	    printBufDeatails(bb,"initial state");
	    
	    int i = 0;
	    while(i++ < 5) {
	    	bb.putInt(i);
	    	printBufDeatails(bb,"write state"+i);
	    }
	    
	    bb.rewind();
	    printBufDeatails(bb,"After rewind");
	    
	    i = 0;
	    while(bb.hasRemaining()) {
	    	System.out.println(bb.getInt());
	    	printBufDeatails(bb,"read state"+i++);
	    }
	    
	    bb.rewind();
	  }
	 
	  private static void printBufDeatails(Buffer bb, String useCase)
	  {
		    System.out.println("usecase#"+useCase);
		  	System.out.println("pos#"+bb.position());
		  	System.out.println("limit#"+bb.limit());
		    System.out.println("mark#"+bb.mark());
		    
	  }
}
