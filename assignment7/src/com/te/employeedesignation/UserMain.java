package com.te.employeedesignation;

import java.util.Iterator;
import java.util.LinkedHashMap;

public class UserMain {
	public static LinkedHashMap<String, String> 
	obtainDesignation(LinkedHashMap<String, String> linkedHashMap, String string) {
		LinkedHashMap<String, String> linkedMap = new LinkedHashMap<String, String>();
		Iterator<String> iterator = linkedHashMap.keySet().iterator();
		while (iterator.hasNext()) {
			String key =  iterator.next();
			String value = linkedHashMap.get(key);
			if (value.equals(string)) {
				linkedMap.put(key, value);
			}
			
		}
		return linkedMap;
	}

}
