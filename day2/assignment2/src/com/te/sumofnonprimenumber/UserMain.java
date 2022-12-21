package com.te.sumofnonprimenumber;

public class UserMain {
     
	static Integer sum=1;
	public static Integer validdateNumber(Integer number) {

		//Integer temp = number;
		Integer count = 0;
		for (int i = 2; i <= number; i++) {

			for (int j = 1; j <= i; j++) {

				if (i % j == 0) {
					count++;
				}
				
			}
			if (count>2) {
				addNumbers(i);
			}
			count=0;
		}
		return sum;
	}

	private static Integer addNumbers(Integer temp) {
		sum=sum+temp;
		return sum;
		
	}

}
