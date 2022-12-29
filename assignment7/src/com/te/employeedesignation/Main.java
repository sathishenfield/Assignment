package com.te.employeedesignation;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the input size");
		Integer inputSize = scanner.nextInt();
		LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<String, String>();
		System.out.println("Enter the input entry(name,Designation)");
		for (int i = 0; i < inputSize; i++) {
			linkedHashMap.put(scanner.next(), scanner.next());
		}
		System.out.println("Enter the designation as you mentioned in input entry");
		String string = scanner.next();
		LinkedHashMap<String, String> linkedMap = UserMain.obtainDesignation(linkedHashMap, string);
		for (Map.Entry<String, String> result : linkedMap.entrySet()) {
			System.out.println("Output is: \n"+result.getKey());
		}
		
	}


}
