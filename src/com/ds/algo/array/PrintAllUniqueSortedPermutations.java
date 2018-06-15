package com.ds.algo.array;

import java.util.Arrays;
/**
 * Approach:
 * 1. Sort the given String and print, it will always be the first permutation in sorted order.
 * 2. Start generating the next higher permutation, Keep doing it until next higher permutation is not possible.
 * 
 * Process:
 * --------
 * Step 1:	Sort the string and print in loop, flag=true in loop and iterate till the the index is -1 make flag as false.
 * Step 2: 	take the previous printed permutation and find the rightmost smaller character than to its next character.
 * 			{i.e start from second last character & go till index 0} and call it first character.
 * Step 3:	Now the find ceil index of the character in the right side of first character, which is greater than first character and smallest to right.
 * Step 4:	Swap the two character first character and the character at ceiling index,
 * Step 5:  Sort the subarray from the next index of first character.
 * Step 6:  Repeat the process.
 * 
 * 
 * @author Prakash2216
 *
 */
public class PrintAllUniqueSortedPermutations 
{

	private static void printSortedUniquePermutaions(String str) 
	{
		int size = str.length();
		System.out.println("Str length "+size);
		boolean flag = true;
		char [] ch =str.toCharArray();
		Arrays.sort(ch);
		System.out.println("char array length "+ch.length);
		
		// Print permutation one by one.
		while(flag)
		{
			//Print permutation.
			System.out.println(ch);
			
			//find the rightmost character, which is less than the next character,
			//call it first character.
			int i;
			for(i = size-2; i>=0; i--)
			{
				if(ch[i] < ch[i+1])
					break;
			}
			
			//if there is no such character all are sorted in decreasing order.
			//means we just printed all the permutations.
			if(i == -1)
				flag = false;
			else
			{			
				// find the ceil of first character to the right of first character.
				//it is the smallest and greater than the first character.
				int ceilIndex = findCeilIndex(ch, ch[i], i+1, size-1);
				
				//Swap the first char and ceil character.
				swap(ch, i, ceilIndex);
				//Sort the array to next from first character.
				Arrays.sort(ch, i+1, size);
			}
		}
	}	
	private static void swap(char[] ch, int i, int ceilIndex) {
		char temp;
		temp = ch[i];
		ch[i] = ch[ceilIndex];
		ch[ceilIndex] = temp;		
	}
	
	//This function finds the index of smallest character
	//which is greater than first and find smaller in right of first.
	private static int findCeilIndex(char [] ch, char first, int l, int h)
	{
		
		int ceilIndex = l;
		
		// Now iterate through rest of the elements and find
	    // the smallest character greater than 'first'
		for(int i = l+1; i<h; i++)
			if(ch[i] > first && ch[i] < ch[ceilIndex])
				ceilIndex=i;
		return ceilIndex;		
	}
	
	public static void main(String[] args) 
	{
		String str = "ABCDC";
		printSortedUniquePermutaions(str);
	}

}
