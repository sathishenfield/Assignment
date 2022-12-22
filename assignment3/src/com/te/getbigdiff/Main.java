package com.te.getbigdiff;

import java.util.Scanner;
import static com.te.getbigdiff.UserMain.*;

public class Main {
	
     public static void main(String[] args) {
		
    	 Scanner scanner=new Scanner(System.in);
    	 
    	 System.out.println("Enter the size of array");
    	 Integer size=scanner.nextInt();
    	 
    	 Integer[] array=new Integer[size];
    	 System.out.println("Enter the values of array");
    	 
    	 for (int i = 0; i < array.length; i++) {
			array[i]=scanner.nextInt();
		}
    	 
    	 Integer bigDiff=getBigDiff(array);
    	 System.out.println("Difference between smallest and largest element in array is: "+bigDiff);
	}
}
