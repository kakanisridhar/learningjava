package com.mridasoft.learning.nio.buffers;

import java.nio.Buffer;
import java.nio.ByteBuffer;

public class BufferMark1 {

	private static final int BSIZE = 1024;

	public static void main(String[] args) {

		//allocate new byte buffer
		ByteBuffer bb = ByteBuffer.allocate(BSIZE);
		printBufDeatails(bb, "initial state");

		//write data
		int i = 0;
		while (i++ < 100) {
			bb.putInt(i);
		}
		
		printBufDeatails(bb, "after writing");
		
		//flip  - sets limit to position, position to start state(say 0)
		bb.flip();
		
		printBufDeatails(bb, "After flip");

		i=0;
		while (i++ < 50 && bb.hasRemaining()) {
			System.out.print(bb.getInt()+" ");
		}
		
		//look ahead 5 ints
		bb.mark();
		printBufDeatails(bb, "After mark");
		
		while (i++ < 55 && bb.hasRemaining()) {
			System.out.print(bb.getInt()+" ");
		}
		
		printBufDeatails(bb, "Before reset");
		
		bb.reset();
		printBufDeatails(bb, "After reset");
		while (bb.hasRemaining()) {
			System.out.print(bb.getInt()+" ");
		}
	}

	private static void printBufDeatails(Buffer bb, String useCase) {
		System.out.println("usecase#" + useCase);
		System.out.println("pos#" + bb.position());
		System.out.println("limit#" + bb.limit());
		//System.out.println("mark#" + bb.mark());

	}
}
