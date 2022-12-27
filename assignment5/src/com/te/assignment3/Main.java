package com.te.assignment3;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter the String and a integer");
		String input=scanner.nextLine();
	    int num=scanner.nextInt();
		String res=UserMain.repeatFirstThreeCharacters(input,num);
		System.out.println(res);
	}

}
