package com.mridasoft.learning.clone;

public class CloneTest implements Cloneable {
	
	private String name;
	private int age;
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	
	public CloneTest(String name,int age){
		this.name = name;
		this.age = age;
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	@Override
	public String toString() {
		return "CloneTest [name=" + name + ", age=" + age + "]";
	}	
	
	
}
