package com.ds.algo.leetcode;

import java.util.Arrays;

public class WordBreakProblemUsingDP 
{
	public static boolean wordBreak(String str)
	{
		int size = str.length();
		
		if(size == 0)									//Base condition
			return true;
		
		boolean [] wb = new boolean[size+1];
		Arrays.fill(wb, false); 						// Assing default value to boolean array
		
		for(int i=1; i<=size; i++)
		{
			if(wb[i] == false && containsDictionary(str.substring(0, i)));
				wb[i] = true;
				
			if(wb[i] == true)
			{
				if(i == size)
					return true;
				
				for(int j = i+1; j<=size; j++)
				{
					if(wb[j] == false && containsDictionary(str.substring(i, j)))
					{
						wb[j] = true;
						
					}
					if(j == size && wb[j] == true)
						return true;
				}
			}
		}
				
		return false;
		
	}
	private static boolean containsDictionary(String str) 
	{
		String [] dictionary = {"mobile","samsung","sam","sung","man","mango", 
                				"icecream","and","go","i","like","ice","cream"};
		
		int size = dictionary.length;
		for(int i =0; i<size; i++)
		{
			if(dictionary[i].equals(str))
				return true;
		}
		return false;
	}
	
	public static void main(String[] args) 
	{
		String input = "ilikesamsungmobile";
		System.out.println(wordBreak(input));
	}

}
