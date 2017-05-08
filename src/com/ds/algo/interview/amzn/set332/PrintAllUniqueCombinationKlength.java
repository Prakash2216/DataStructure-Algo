package com.ds.algo.interview.amzn.set332;

import java.util.Arrays;
/**
 * Generate all k length combination from n length string, characters can appear multiple times.
 * print unique combinations only.
 * 
 * @author Prakash Singh
 *
 */
public class PrintAllUniqueCombinationKlength {

	public static void main(String[] args) {
		char [] arr = {'a','b','a','b','c'};
		int k=3;
		PrintAllUniqueCombinationKlength obj = new PrintAllUniqueCombinationKlength();
		obj.printCombinationKUnique(arr, k);
	}

	private void printCombinationKUnique(char[] arr, int k) {
		if(arr.length == 0)
			return;
		
		Arrays.sort(arr);
		System.out.println(arr);
		printCombinationKUniqueUtil(arr, "", k);
		
	}

	private void printCombinationKUniqueUtil(char[] arr, String str, int k) {
		
		if(k == 0) {
			System.out.println(str);
			return;
		}
		else {
			for(int i=0; i<arr.length; i++) {
				
				if(i > 0 && arr[i] == arr[i-1])
					continue;
				String newstr = str+arr[i];
				printCombinationKUniqueUtil(arr, newstr, k-1);
			}
		}
	}

}
