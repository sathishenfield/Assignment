package com.te.assignment10;

public class UserMain {
	
	public static String findNoDigits(Double value) {
		String input = String.valueOf(value);
		String[] array=input.split("\\.");
		Integer beforeDecimal = Integer.valueOf(array[0]);
		Integer afterDecimal = Integer.valueOf(array[1]);
		Integer beforeDecimalCount = 0;
		Integer afterDecimalCount = 0;

		while (beforeDecimal > 0) {
			beforeDecimalCount++;
			beforeDecimal /= 10;
		}
		while (afterDecimal > 0) {
			int temp = afterDecimal % 10;
			if (temp != 0) {
				afterDecimalCount++;
			}
			afterDecimal /= 10;

		}
		String result = beforeDecimalCount.toString() + ":" + afterDecimalCount.toString();
		return result;
		
	}

}
