package com.te.stateidgenerator;

import java.util.ArrayList;
import java.util.HashMap;

public class UserMain {
	public static HashMap<String, String> getStateId(String[] string) {
		HashMap<String, String> hashMap = new HashMap<String, String>();
		ArrayList<String> list1=new ArrayList<String>();
		ArrayList<String> list2=new ArrayList<String>();
		for (String string1 : string) {
			list1.add(string1.toUpperCase().substring(0, 3));
		}
		for (String string1 : string) {
			list2.add(string1);
		}
		for (int i = 0; i < string.length; i++) {
			hashMap.put(list1.get(i), list2.get(i));
		}
		
		return hashMap;
	}

}
