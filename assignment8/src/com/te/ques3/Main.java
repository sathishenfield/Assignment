package com.te.ques3;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter the date in DD-MM-YYYY format");
		String input=scanner.next();
		System.out.println(UserMain.getLastDayOfMonth(input));
	}

}
