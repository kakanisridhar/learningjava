package com.mridasoft.utils.password;

import java.security.SecureRandom;

public class RandomPassowrdGenerator {
	private static final String capAlphaSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
	private static final String numCharSet = "0123456789";
	private static final String spclCharSet = "#@!&";
	private static final int alphabetsLen = 6;
	private static final int numericLen = 1;
	private static final int specialCharLen = 1;

	public static void main(String[] args) {
		
		SecureRandom rndm = new SecureRandom();
		
		StringBuffer pwd = new StringBuffer();
		
		for (int i = 0; i < alphabetsLen; i++)
			pwd.append(capAlphaSet.charAt(rndm.nextInt(capAlphaSet.length())));
		
		for (int i = 0; i < numericLen; i++)
			pwd.append(numCharSet.charAt(rndm.nextInt(numCharSet.length())));
		
		for (int i = 0; i < specialCharLen; i++)
			pwd.append(spclCharSet.charAt(rndm.nextInt(spclCharSet.length())));
		
		System.out.println(pwd);

		StringBuffer pwdFinal = new StringBuffer();
		int randIndex;
		int len = pwd.length();
		for (int i = 0; i < len; i++) {
			randIndex = rndm.nextInt(pwd.length());
			pwdFinal.append(pwd.charAt(randIndex));
			pwd.deleteCharAt(randIndex);
		}
		System.out.println("pwdFinal : " + pwdFinal);
	}

}