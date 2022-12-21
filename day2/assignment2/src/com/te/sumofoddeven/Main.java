package com.te.sumofoddeven;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
	
	Scanner sc=new Scanner(System.in);
	System.out.println("enter the number");
	Integer number=sc.nextInt();
	Integer result=UserMain.sumOffOddEvenPositioned(number);
    if(result==1)
    {
    	System.out.println("true");
    }
    else
    {
    	System.out.println("false");
    }
	}

}
