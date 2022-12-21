package com.te.luckysum;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the number1");
		Integer number1 = scanner.nextInt();
		System.out.println("Enter the number2");
		Integer number2 = scanner.nextInt();
		System.out.println("Enter the number3");
		Integer number3 = scanner.nextInt();
		
		Integer result = UserMain.getLuckySum(number1,number2,number3);
		
		System.out.println("Lucky sum is "+result);
	}


}
