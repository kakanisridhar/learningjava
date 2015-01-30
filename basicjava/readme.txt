Core Java


NIO

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



NIO - File related


Path 
	- represent just a path, nothing more.
 	not necessary for the path to exist on system
	
	getFileName
	getNameCount
	getName
	getParent
	getRoot 
	
	normalize - resolves .. , .   - working only with /, \\.. is not working
	
	toRealPath - resolves symlinks and converts a path to real path 
	
Paths 
	- helper class containg static methods for working on paths

Files 
	- contains static helper methods for reading/writing files

FileSystems -

FileSystem -

Walking a directory tree - 

Waching/Events a file - 








Generics



naming conventions for generic types

    E - Element (used extensively by the Java Collections Framework)
    K - Key
    N - Number
    T - Type
    V - Value
    S,U,V etc. - 2nd, 3rd, 4th types
    
<> operator is used for type inference    


generic classes( classes using templates)
	defined by appending templates in angular brackets immediately to the class
	i.e OrderedPair<K, V>
	
generic methods
    defined by appending templates in angular brackets immediately to the method signature
    Static and non-static generic methods are allowed, as well as generic class constructors. 	 	
    
raw types
	A raw type is the name of a generic class or interface without any type arguments.
	non generic types are not raw types.

Bounded Type Parameters aka Type limiting
	
	<T extends Serializable> 
	for example a generic Entity<T extends Serializable> class which accepts a serializable identifier.
    
Usage of generics

	compile type verification of what is kept in containers.
	generic algorithms using type limiting  


generics, inheritance, subtypes

	Container<Integer> is not a subclass of Container<Number> even though Integer is a subtype of number.
	
	if you are defining any generic methods use wildcards   

   
Type Erasure

	in java generics work by type erasure i.e there is only one class which is loaded in memory.

Type inference
	
	from jdk 7 compilers can make out constructed object types based upon declaration
	
	example
	class MyClass<X> {
	  //this is class constructor, constructors have no return types 
	  <T> MyClass(T t) {
	  }
	}
	
	MyClass<String> a = new  MyClass<>(1);
	here compiler infers that class templates a string while constructor accepts an integer 

Wildcards

	? in place of actual type
	
	uses - 
	
	upper bounding of type  - e.g <? extends Number> to have a generic algorithm for listing out all numbers.
		however this methods cannot add any new elements even if the type expected is a non abstract class 

	unbounded wild cards - e.g <?> used for accepting any types because  
		List<Object> is not List<Integer> and List<Integer> does not inherit from list<Object>
	
	lower bounded wildcards - <? super Integer>  - used for adding integers to any containers which accept numbers/objects..
	
	
	For adding entries into containers with bounded wild cards use
	generic helper method (which will have info about type thanks to type inference)   - see java tutorial on oracle
	
	
	
	Wildcard Guidelines: **from java tuorial 

    An "in" variable is defined with an upper bounded wildcard, using the extends keyword.
    An "out" variable is defined with a lower bounded wildcard, using the super keyword.
    In the case where the "in" variable can be accessed using methods defined in the Object class, use an unbounded wildcard.
    In the case where the code needs to access the variable as both an "in" and an "out" variable, do not use a wildcard.
	
	
		
	
		