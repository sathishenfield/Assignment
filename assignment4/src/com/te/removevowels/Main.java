package com.te.removevowels;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the input");
		String input = scanner.nextLine();

		String result = UserMain.removeEvenVowels(input);
		System.out.println("Removing even position vowels is= "+result);
	}

}
