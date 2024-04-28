package com.mridasoft.learning.inheritance;

public class InstanceTest {

    public static void main(String[] args) {
 
        BaseClass b = new BaseClass();
        DerivedClass d = new DerivedClass();
 
        //
        // instanceof
        //
        
        if ( d instanceof BaseClass ) {
        	System.out.println("d instance of baseclass");
        }
        
        if ( b instanceof DerivedClass ) {
        	System.out.println("b instance of DerivedClass");
        }
       
        if(BaseClass.class.isAssignableFrom(d.getClass())){
        	System.out.println("casting to base class is allowed for oject d");
        }
 
        if(DerivedClass.class.isAssignableFrom(b.getClass())){
        	System.out.println("casting to derived class is allowed for oject b");
        }
        
        if(DerivedClass.class.isInstance(b)){
        	System.out.println("b isinstance D");
        }
        
        if(BaseClass.class.isInstance(d)){
        	System.out.println("d isinstance B");
        }
        
        
        
        //if ( B instanceof a ) {} // Illegal
        //if ( b instanceof a ) {} // Illegal
        if ( b instanceof BaseClass ) {} // OK

        if ( null instanceof BaseClass ) {} // OK

 
    }
 
}