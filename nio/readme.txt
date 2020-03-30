http://tutorials.jenkov.com/java-nio/overview.html
http://www.javaworld.com/article/2078654/java-se/java-se-five-ways-to-maximize-java-nio-and-nio-2.html?null
http://java.dzone.com/articles/java-nio-vs-io

imagine a coal mine - all you can see is a container of coal(buffer) transported using a track(channel)

Buffer 
      	-  interface for buffer operations 
      	-  invariants - 0 <= mark <= position <= limit <= capacity 
	  	-  hasRemaining -  can be used to check for availability of data

Types of buffers in java

	  	ByteBuffer,CharBuffer,IntBuffer,ShortBuffer,LonBuffer,floatBuffer,DoubleBuffer, MappedByteBuffer 
	  
	  
Channel	
	    - interface(isopen and close) for getting data

Charset 
		- encode, decode
		