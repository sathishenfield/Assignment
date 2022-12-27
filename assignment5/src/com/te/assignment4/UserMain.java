package com.te.assignment4;

import java.util.Scanner;

public class UserMain {
	
	public static String formString(Integer input,Integer pos) {
		Scanner scanner=new Scanner(System.in);
		StringBuffer output=new StringBuffer();
		String[] arr=new String[input];
		for (int i = 0; i < arr.length; i++) {
			System.out.println("Enter the String");
			arr[i]=scanner.nextLine();
		}
		for (int i = 0; i < arr.length; i++) {
			try {
				output.append(arr[i].charAt(pos-1));
			} catch (IndexOutOfBoundsException e) {
				output.append('$');
			}
		}
		return output.toString();
	}
	

}
