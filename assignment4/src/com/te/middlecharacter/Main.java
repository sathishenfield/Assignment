package com.te.middlecharacter;

import java.util.Scanner;

public class Main {
	static Scanner scanner=new Scanner(System.in);
	
	public static void main(String[] args) {
		
		System.out.println("Enter the word");
		String input=scanner.next();
		
		if (input.length()%2==0) {
			String result=UserMain.getMiddleChars(input);
			System.out.println(result);
		}
		else {
			System.out.println("Enter even length");
		}
	}

}
