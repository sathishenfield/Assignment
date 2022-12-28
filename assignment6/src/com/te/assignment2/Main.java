package com.te.assignment2;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ArrayList<Integer> arrayList1 = new ArrayList<Integer>();
		ArrayList<Integer> arrayList2 = new ArrayList<Integer>();
		ArrayList<Integer> result = new ArrayList<Integer>();
		System.out.println("Enter the input ArrayList1:");
		for (int i = 0; i < 5; i++) {
			arrayList1.add(scanner.nextInt());
		}
		System.out.println("Enter the input ArrayList2:");
		for (int j = 0; j < 5; j++) {
			arrayList2.add(scanner.nextInt());
		}
		result=UserMain.sortMergedArrayList(arrayList1,arrayList2);
		System.out.println("output is: ");
		for (int k = 0; k < 3; k++) {
			System.out.println(result.get(k));
		}
	}
	

}
