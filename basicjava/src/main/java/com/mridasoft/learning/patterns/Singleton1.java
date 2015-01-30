package com.mridasoft.learning.patterns;

//Singleton using a holder
public class Singleton1 {
    // Private constructor prevents instantiation from other classes
    private Singleton1() { }

    /**
    * SingletonHolder is loaded on the first execution of Singleton.getInstance() 
    * or the first access to SingletonHolder.INSTANCE, not before.
    */
    private static class SingletonHolder { 
            public static final Singleton1 INSTANCE = new Singleton1();
    }

    public static Singleton1 getInstance() {
            return SingletonHolder.INSTANCE;
    }
}

