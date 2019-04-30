package com.ds.algo.DP;

import java.util.HashMap;
import java.util.Map;

/**
 * This question was asked in Amazon interview. This problem is an extension of word break problem.
 * 
 * An Already implemented dictionary is given. write a program, A method which takes an input string without spaces, replace the character
 * from the input string, which are not present in the dictionary.
 * 
 * 
 * @author 1019270
 *
 */
public class ReplaceCharacterInWordBreak 
{
	public static boolean containsDictionary(String str)
	{
		if(str == null)
			return true;
		Map<String, String> dictionary = new HashMap<String, String>();
		
		dictionary.put("a", "a");
		dictionary.put("aa", "aa");
		dictionary.put("aaa", "aaa");
		
		String temp = dictionary.get(str);
		if(temp != null)
			return true;
		return false;
	}
	
	public static void replaceCharWordBreak(String input)
	{
		if(input == null)
			return;
		
		char [] carr = input.toCharArray();
		
		int size = carr.length;
		
		for(int i=0; i<size; i++)
		{
			if(!containsDictionary(Character.toString(carr[i])))
			{
				carr[i] = ' ';
			}
		}
		System.out.println(carr);
	}
	public static void main(String[] args) 
	{
		String input = "aaabaa";
		replaceCharWordBreak(input);
		
		System.out.println("done");

	}

}
