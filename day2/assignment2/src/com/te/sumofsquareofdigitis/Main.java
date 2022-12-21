package com.te.sumofsquareofdigitis;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner =new Scanner(System.in);
		System.out.println("Enter The Number");
		Integer number = scanner.nextInt();
		Integer result = UserMain.getSumOfSquaresOfDigits(number);
		System.out.println("Sum of Squares of digits = "+result);
	}


}
