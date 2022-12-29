package com.te.statescapitals;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the input size");
		Integer inputSize = scanner.nextInt();
		HashMap<String, String> hashMap = new HashMap<String, String>();
		System.out.println("Enter the input entry(state,capital)");
		for (int i = 0; i < inputSize; i++) {
			hashMap.put(scanner.next(), scanner.next());
		}
		System.out.println("Enter the state name as you mentioned in input entry");
		String string = scanner.next();
		String result = UserMain.getCapital(hashMap,string);
		System.out.println("Output is: " + result);
	}

}
