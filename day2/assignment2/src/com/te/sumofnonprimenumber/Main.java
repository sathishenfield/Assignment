package com.te.sumofnonprimenumber;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the number");
		Integer number=sc.nextInt();
		Integer sum=UserMain.validdateNumber(number);
		System.out.println(sum);
	}

}