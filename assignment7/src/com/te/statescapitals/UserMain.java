package com.te.statescapitals;

import java.util.HashMap;
import java.util.Iterator;

public class UserMain {
	public static String getCapital(HashMap<String, String> hashMap, String string) {
		Iterator<String> iterator = hashMap.keySet().iterator();
		StringBuffer buffer=new StringBuffer();
		while (iterator.hasNext()) {
			String stateKey = iterator.next();
			String capitalValue = hashMap.get(stateKey);
			if (stateKey.equalsIgnoreCase(string)) {
				buffer.append(capitalValue).append('$').append(stateKey);
			}
			
		}
		return buffer.toString().toLowerCase();
	}

}
