package com.te.assignment5;

import java.util.ArrayList;

public class UserMain {
	static ArrayList<String> matchCharacter(String[] string) {
		ArrayList<String> arrayList = new ArrayList<String>();
		for (int i = 0; i < string.length; i++) {
			if(string[i].charAt(0)=='a'||string[i].charAt(0)=='e'||string[i].charAt(0)=='i'
					||string[i].charAt(0)=='o'||string[i].charAt(0)=='u'&&string[i].charAt(string[i].length()-1)=='a'||
							string[i].charAt(string[i].length()-1)=='e'||string[i].charAt(string[i].length()-1)=='i'||
									string[i].charAt(string[i].length()-1)=='o'||string[i].charAt(string[i].length()-1)=='u'){
				arrayList.add(string[i]);
										
									}
									
									
			
		}
		
		return arrayList;
	}

}
