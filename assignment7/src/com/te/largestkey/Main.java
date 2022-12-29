package com.te.largestkey;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the input size");
		Integer inputSize = scanner.nextInt();
		HashMap<Integer, String> hashMap = new HashMap<Integer, String>();
		System.out.println("Enter the input entry(Integer,String)");
		for (int i = 0; i < inputSize; i++) {
			hashMap.put(scanner.nextInt(), scanner.next());
		}
		String result =UserMain.getMaxKeyValue(hashMap);
		System.out.println("Output is: "+result);
	}


}
