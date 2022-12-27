package com.te.assignment3;

public class UserMain {

	public static String repeatFirstThreeCharacters(String input, int num) {
		StringBuffer output = new StringBuffer();
		if (input.length() < 3) {
			for (int i = 0; i < num; i++) {
				output = output.append(input);
			}
			return output.toString();
		} else {
			for (int i = 0; i < num; i++) {
				output = output.append(input.substring(0, 3));
			}
			return output.toString();

		}
		

	}

}
