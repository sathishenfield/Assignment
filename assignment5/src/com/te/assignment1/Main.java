package com.te.assignment1;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the string and then a character Symbol to split");
		String res = UserMain.reShape(scanner.next(), scanner.next().charAt(0));
		System.out.println(res);
	}

}
