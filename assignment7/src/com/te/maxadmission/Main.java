package com.te.maxadmission;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the input size");
		Integer inputSize = scanner.nextInt();
		HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
		System.out.println("Enter the input entry(Integer,Integer)");
		for (int i = 0; i < inputSize; i++) {
			hashMap.put(scanner.nextInt(), scanner.nextInt());
		}
		Integer result = UserMain.getYear(hashMap);
		System.out.println("Output is: " + result);
	}


}
