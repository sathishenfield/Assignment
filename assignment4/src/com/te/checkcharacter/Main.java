package com.te.checkcharacter;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		
		System.out.println("Enter the Sentence");
		String input=scanner.nextLine();
		
		Integer result=UserMain.checkCharacters(input);
		
		if (result==1) {
			System.out.println("Valid");
		}
		
		else {
			System.out.println("Invalid");
		}
	}

}
