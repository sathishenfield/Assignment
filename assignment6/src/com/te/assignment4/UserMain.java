package com.te.assignment4;

import java.util.ArrayList;
import java.util.Iterator;

public class UserMain {
	
      
	public static ArrayList<Integer> removeMulitipleOfThree(ArrayList<Integer> arrayListInput) {
		ArrayList<Integer> arrayList=new ArrayList<Integer>();
		Iterator<Integer> iterator=arrayListInput.iterator();
		while (iterator.hasNext()) {
			arrayList.add(iterator.next());
			arrayList.add(iterator.next());
			iterator.next();
		}
		return arrayList;
	}

}
