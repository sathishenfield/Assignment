package com.te.removevowels;

public class UserMain {

	public static String removeEvenVowels(String input) {
		StringBuffer stringBuffer = new StringBuffer();
		for (int i = 0; i < input.length(); i++) {

			if ((i % 2) == 0) {

				 stringBuffer.append(input.charAt(i));
			}
			else {
				if (input.charAt(i) != 'a' && input.charAt(i) != 'e' && input.charAt(i) != 'i' && input.charAt(i) != 'o'
						&& input.charAt(i) != 'u' && input.charAt(i) != 'A' && input.charAt(i) != 'E'
						&& input.charAt(i) != 'I' && input.charAt(i) != 'O' && input.charAt(i) != 'U') {

					stringBuffer.append(input.charAt(i));

				}
				else {
					stringBuffer.append("");
				}
		}

		}
		return stringBuffer.toString();

	}
}
