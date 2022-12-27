package com.te.assignment1;

public class UserMain {
	
	public static String reShape(String input, char x) {
		StringBuffer buffer = new StringBuffer(input);
		String rev = new String(buffer.reverse());
		StringBuffer revcon = new StringBuffer();
		for (int i = 0; i < rev.length(); i++) {
			revcon.append( Character.toString(x)+ rev.charAt(i));

		}
		System.out.println(rev);
		revcon.deleteCharAt(0);

		return revcon.toString();
	}


}
