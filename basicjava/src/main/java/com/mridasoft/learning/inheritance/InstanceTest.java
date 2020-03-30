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
        if ( b instanceof I ) {} // OK
 
        if ( null instanceof BaseClass ) {} // OK
        //if ( b instanceof null ) {} // Illegal
 
        //if ( b instanceof b.getClass() ) {} // Illegal
 
        //if ( b instanceof double ) {} // Illegal
        //if ( b instanceof Double ) {} // Illegal
        //if ( b instanceof double.class ) {} // Illegal
        //if ( b instanceof Double.class ) {} // Illegal
 
        //
        // isAssignableFrom()
        //
 
        // All OK
        if ( BaseClass.class.isAssignableFrom(B.class) ) {}
        if ( BaseClass.class.isAssignableFrom(b.getClass()) ) {}
        if ( a.getClass().isAssignableFrom(B.class) ) {}
        if ( a.getClass().isAssignableFrom(b.getClass()) ) {}
 
        // All OK
        if ( double.class.isAssignableFrom(double.class) ) {}
        if ( Double.class.isAssignableFrom(Double.class) ) {}
        if ( double.class.isAssignableFrom(B.class) ) {}
        if ( Double.class.isAssignableFrom(b.getClass()) ) {}
 
        // All OK
        if ( I.class.isAssignableFrom(double.class) ) {}
        if ( I.class.isAssignableFrom(Double.class) ) {}
 
        Class c = null;
 
        // Throws NullPointerException at runtime
        if ( A.class.isAssignableFrom(c) ) {}
 
        //
        // isInstance()
        //
 
        b = null;
 
        // All OK
        if ( A.class.isInstance(b) ) {}
        if ( a.getClass().isInstance(b) ) {}
        if ( double.class.isInstance(b) ) {}
        if ( Double.class.isInstance(b) ) {}
        if ( I.class.isInstance(b) ) {}
 
         // Throws NullPointerException at runtime
         if ( c.isInstance(a) ) {}
 
    }
 
}