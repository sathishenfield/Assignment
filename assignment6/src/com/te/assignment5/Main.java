package com.te.assignment5;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the input Size ");
		Integer input=scanner.nextInt();
		System.out.println("Enter the input elements");
		String[] string=new String[input];
		for (int i = 0; i < input; i++) {
			string[i]=scanner.next();
		}
		ArrayList<String> result=UserMain.matchCharacter(string);
		System.out.println("output is: \n");
		for (String string2 : result) {
			System.out.println(string2);
		}
	}
}
