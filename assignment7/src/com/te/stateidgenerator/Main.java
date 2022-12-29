package com.te.stateidgenerator;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the input size");
		Integer inputSize = scanner.nextInt();
		String[] string = new String[inputSize];
		System.out.println("Enter the input state");
		for (int i = 0; i < inputSize; i++) {
			string[i]=scanner.next();
		}
		HashMap<String,String> hashMap = UserMain.getStateId(string);
		for (Map.Entry<String, String> result : hashMap.entrySet()) {
			System.out.println(result.getKey()+":"+result.getValue());
		}
		
	}


}
