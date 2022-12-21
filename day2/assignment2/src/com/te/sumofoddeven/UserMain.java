package com.te.sumofoddeven;

public class UserMain {

	public static int sumOffOddEvenPositioned(int number)
	{
		Integer temp=number;
		Integer lastDigit;
		Integer sumOfOdd=0;
		Integer sumOfEven=0;
		
		while (number!=0) {
			lastDigit=number%10;
			sumOfOdd=lastDigit+sumOfOdd;
			number/=10;
			number/=10;
			
		}
		temp/=10;
		while (temp!=0) {
			lastDigit=temp%10;
			sumOfEven=lastDigit+sumOfEven;
			temp/=10;
			temp/=10;
			
		}
		System.out.println(sumOfEven);
		System.out.println(sumOfOdd);
		
		if (sumOfEven==sumOfOdd) {
			return 1;
		}
		return -1;
		
	}

}
