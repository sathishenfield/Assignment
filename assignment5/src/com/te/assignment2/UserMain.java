package com.te.assignment2;

public class UserMain {

	
	public static Integer getSubstring(String input, String x) {

		Integer flag = 0;
		while (input.contains(x)) {

			flag++;
			input = input.replaceFirst(x, "-");

		}

		return flag;
	}
}
