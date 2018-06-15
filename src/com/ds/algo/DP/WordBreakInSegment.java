package com.ds.algo.DP;

import java.util.Arrays;

public class WordBreakInSegment 
{
	private static String [] dictionary = {"mobile","samsung","sam","sung","man","mango","icecream","and","go","i","like","ice","cream"};
	
	public static boolean dictionaryContains(String word)
	{
		int size = dictionary.length;
		for(int i=0; i<size; i++)
			if(dictionary[i].compareTo(word) == 0)
				return true;
		return false;
	}
	
	//This is Recursive approach to solve the segmented problem
	public static boolean wordBreak(String str)
	{
		int size = str.length();
		
		//Base condition
		if(size == 0)
			return true;
		
		for(int i=1; i<=size; i++)
		{
			if(dictionaryContains(str.substring(0, i)) && wordBreak(str.substring(i, size)))
				return true;
		}
		return false;
	}
	
	/*DP Approach
	 * 1. if we are using the 0 or 1 to fill the wb table it just tells, whether given string is segmented and according to given dictionay.
	 * 
	 * 2. For printing the segmented word we are assigning the count of word encountered.
	 * 
	 */
	public static int wordBreakDP(String str)
	{
		int size = str.length();
		
		if(size == 0)
			return 0;
		
		int [] wb = new int[size+1];
		Arrays.fill(wb, 0);
		
		for(int i=0; i<=size; i++)
		{
			if(wb[i] == 0 && dictionaryContains(str.substring(0, i)))
				wb[i] = 1;
			
			if(wb[i] == 1)
			{
				int j;
				for(j=i+1; j<=size; j++)
				{
					if(wb[j] == 0 && dictionaryContains(str.substring(i, j)))
						wb[j] = 1;
				}
				
									
			}	
			if(i == size && wb[i] == 1)
				return 1;
		}
		
		for(int p =0 ; p<=size; p++)
			System.out.print(wb[p]+" ");
		return wb[size];
	}
	
	public static void main(String[] args) 
	{
		
		System.out.println(wordBreakDP("ilikesamsung") == 1 ? "yes" : "no");
	}

}
