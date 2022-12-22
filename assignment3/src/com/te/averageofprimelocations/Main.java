package com.te.averageofprimelocations;

import java.util.Scanner;
import static com.te.averageofprimelocations.UserMain.*;

public class Main {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);

		System.out.println("Enter the size of array");
		Integer size=scanner.nextInt();

		Integer[] array=new Integer[size];
		System.out.println("Enter the values of array");

		for (int i = 0; i < array.length; i++) {
			array[i]=scanner.nextInt();
		}
		
		Double averageElements=averageElements(array);
		System.out.println("Average of prime locations is: "+averageElements);

	}

}
