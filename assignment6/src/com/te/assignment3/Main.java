package com.te.assignment3;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter the size of input");
		Integer input = scanner.nextInt();
		ArrayList<String> arrayListInput = new ArrayList<String>();
		for (int i = 0; i < input; i++) {
			arrayListInput.add(scanner.next());
		}
		String [] strings= UserMain.convertToStringArray(input,arrayListInput);
		for (String string : strings) {
			System.out.println(string);
		}
	}


}
