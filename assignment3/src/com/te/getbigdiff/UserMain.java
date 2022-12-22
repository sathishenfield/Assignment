package com.te.getbigdiff;

public class UserMain {
	
	public static Integer getBigDiff(Integer[] array) {
		
		Integer largestNumber=array[0];
		Integer smallestNumber=array[0];
		Integer bigDiff=0;
		
		for (int i = 0; i < array.length; i++) {
			
			if (array.length==1) {
				return array[0];
			}
			
			else if (largestNumber<array[i]) {
				largestNumber=array[i];
			}
			
			else if(smallestNumber>array[i])
			{
				smallestNumber=array[i];
			}
		}
		bigDiff=largestNumber-smallestNumber;
		return bigDiff;
		
	}

}
