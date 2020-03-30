package com.mridasoft.learning.clone;

public class CloneTestAspp {
	
	public static void main(String[] args) {
		CloneTest t1 = new CloneTest("Sreedhara",33);
		CloneTest t2 = null;
		try {
			t2 = (CloneTest) t1.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(t1);
		System.out.println(t2);
	}

}
