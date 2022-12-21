package com.te.sumofsquareofdigitis;

public class UserMain {
	public static Integer getSumOfSquaresOfDigits(Integer number) {
		Integer temp=number;
		Integer remainder = 0;
		Integer sum =0;
		while (temp!=0) {
			remainder=temp%10;
			sum=sum+(remainder*remainder);
			temp=temp/10;
		}
		return sum;
	}

}
