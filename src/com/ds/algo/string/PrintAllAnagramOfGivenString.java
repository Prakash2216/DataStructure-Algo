package com.ds.algo.string;

import java.util.Arrays;

/**
 * Given an array of String. Print all anagram of a given string in array in same order they are in array.
 * 
 * 
 * Approach: 
 * 	step 1: Sort the given string.
 *  Step 2: iterate over array and sort each word and compare with the given string. 
 *  		if equal
 *  			print the string
 * 
 * Complexity	: O((n+1)mlogm)
 * 				n = size of the array.
 * 				m = size of
 * 	
 * @author 1019270
 *
 */
public class PrintAllAnagramOfGivenString 
{
	
	public static void printAnagram(String[] sarr, String str)
	{
		char [] carr = str.toCharArray();
		Arrays.sort(carr);
		//System.out.println(carr);
		String scarr = String.valueOf(carr);
		for(String s : sarr)
		{
			char [] temp = s.toCharArray();
			Arrays.sort(temp);
			if(scarr.equals(String.valueOf(temp)))
				System.out.println(s);
		}
	}
	public static void main(String[] args) 
	{
		String [] sarr = {"cat", "dog", "act", "god", "tac"};
		String str = "cta";
		printAnagram(sarr, str);
	}

}
