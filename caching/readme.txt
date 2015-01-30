Implement 

SizedCache - which maintains cache with size
             which removes old entries when memory runs out
             
ideas - 
		use k,v
		use concurrentmap
		use wrapper<T> gor wrapping v
			  -val
			  -seqnumber
		create cleaner thread which can remove entities(removal strategy)
			 when free memory is less than passed memory
		
		removal strategy = less frequently used 	 
					             
             
SoftPool - which maintains soft references to objects 
		   whose values get gced if system runs out of memory
		   


		   
******Work in progress		   
		     				             
             