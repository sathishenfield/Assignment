package com.te.assignmnet6;

import java.util.ArrayList;

public class UserMain {
	
	public static Integer addAndReverse(Integer[] array, Integer number) {
		Integer sum = 0;
		Integer rev = 0;
		ArrayList<Integer> arrayList = new ArrayList<Integer>();

		for (int i = 0; i < array.length; i++) {
			if (array[i] > number) {
				arrayList.add(array[i]);
			}
		}
		for (int i = 0; i < arrayList.size(); i++) {
			sum += arrayList.get(i);

		}
		while (sum > 0) {
			int last = sum % 10;
			rev = rev * 10 + last;
			sum /= 10;
		}
		return rev;

	}

}
