package com.te.assignmnet6;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter the size of the array");
		Integer[] array=new Integer[scanner.nextInt()];
		for (int i = 0; i < array.length; i++) {
			System.out.println("Enter element : "+i);
			array[i]=scanner.nextInt();
		}
		System.out.println("Enter an Integer value");
		Integer number=scanner.nextInt();
		
		System.out.println(UserMain.addAndReverse(array, number));
		
	}

}
