package com.mridasoft.learning.nio.buffers;

import java.nio.Buffer;
import java.nio.ByteBuffer;

public class Buffer1 {

	private static final int BSIZE = 1024;

	public static void main(String[] args) {

		//allocate new byte buffer
		ByteBuffer bb = ByteBuffer.allocate(BSIZE);
		printBufDeatails(bb, "initial state");

		//write data
		int i = 0;
		while (i++ < 5) {
			bb.putInt(i);
		}
		
		printBufDeatails(bb, "after writing");
		
		//flip  - sets limit to position, position to start state(say 0)
		bb.flip();
		
		printBufDeatails(bb, "After flip");

		i = 0;
		while (bb.hasRemaining()) {
			System.out.println(bb.getInt());
			printBufDeatails(bb, "read state" + i++);
		}

		bb.clear();
		printBufDeatails(bb, "After clear");
	}

	private static void printBufDeatails(Buffer bb, String useCase) {
		System.out.println("usecase#" + useCase);
		System.out.println("pos#" + bb.position());
		System.out.println("limit#" + bb.limit());
		//System.out.println("mark#" + bb.mark());

	}
}
