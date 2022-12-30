package com.te.ques4;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter the value");
		Integer size=scanner.nextInt();
		HashMap<String, Float> map=new HashMap<String, Float>();
		for (int i = 0; i < size; i++) {
			map.put(scanner.next(), scanner.nextFloat());
		}
		String[] arr=new String[scanner.nextInt()];
		for (int i = 0; i < arr.length; i++) {
			arr[i]=scanner.next();
		}
		System.out.println(UserMain.costEstimator(map, arr));
	}

}
