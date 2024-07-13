package com.mridasoft.learning.networking;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Lesson1 {
	
	public static void main(String[] args) {
		String hn;
		try {
			hn = InetAddress.getLocalHost().getHostName();
			System.out.println(hn);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}

}
