package com.te.assignment9;

public class UserMain {
	
	public static Boolean searchSequence(Integer[] array) {
		Boolean sequence = false;
		for (int i = 0; i < array.length; i++) {
			if (i < array.length - 2 && array[i] == 1 && array[i + 1] == 2 && array[i + 2] == 3) {
				sequence = true;
			}
		}
		return sequence ? true : false;

	}

}
