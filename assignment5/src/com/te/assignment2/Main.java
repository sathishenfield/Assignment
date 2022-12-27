package com.te.assignment2;

import java.util.Scanner;

public class Main {

	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the string and then a character Symbol to split");
		Integer res = UserMain.getSubstring(scanner.nextLine(), scanner.nextLine());
		System.out.println(res);
	}
}
