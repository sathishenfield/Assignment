package com.te.assignment1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter size of an input");
		Integer inputSize = scanner.nextInt();
		ArrayList<Integer> arrayList1 = new ArrayList<Integer>();
		ArrayList<Integer> arrayList2 = new ArrayList<Integer>();
		ArrayList<Integer> arrayList3 = new ArrayList<Integer>();
		System.out.println("Enter the input ArrayList1:");
		for (int i = 0; i < inputSize; i++) {
			arrayList1.add(scanner.nextInt());
		}
		System.out.println("Enter the input ArrayList2:");
		for (int j = 0; j < inputSize; j++) {
			arrayList2.add(scanner.nextInt());
		}
		arrayList3 = UserMain.generateOddEvenList(arrayList1, arrayList2);
		Iterator<Integer> iterator = arrayList3.iterator();
		while (iterator.hasNext()) {
			Integer result = iterator.next();
			System.out.println(result);
		}
	}

}
