package com.te.assignment4;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the Integer");
		Integer input = scanner.nextInt();
		System.out.println("Enter the position");
		Integer pos=scanner.nextInt();
		String res = UserMain.formString(input,pos);
		System.out.println(res);
	}

}
