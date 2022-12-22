package com.te.sumofpower;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the size of an array");
		Integer size= scanner.nextInt();
		Integer[] a= new Integer [size];
		System.out.println("Enter the elements");
		for (int i = 0; i < a.length; i++) {
		a[i]=scanner.nextInt();
			
		}
		Integer result = UserMain.getSumOfPower(a);
		
		System.out.println("Sum of Powers of elements in an array "+result);
	}

}
