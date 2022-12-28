package com.te.assignment4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter the size of input");
		Integer input = scanner.nextInt();
		ArrayList<Integer> arrayListInput = new ArrayList<Integer>();
		for (int i = 0; i < input; i++) {
			arrayListInput.add(scanner.nextInt());
		}
		ArrayList<Integer> arrayList = UserMain.removeMulitipleOfThree(arrayListInput);
		Iterator<Integer> iterator=arrayList.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
			
		}
	}

}
