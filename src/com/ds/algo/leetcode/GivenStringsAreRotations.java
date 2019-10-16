package com.ds.algo.leetcode;
/**
 * WAP to check whether given two strings are rotations of each other.
 * 
 * Ex: Given two strings s1 and s2, check whether s2 is a rotation of s1.
 * Input : ABACD, CDABA
 * Output : True
 * Input : GEEKS, EKSGE
 * Output : True
 * 
 * 
 * @author lightster
 *
 */
public class GivenStringsAreRotations 
{
	/**
	 *  In this approach we concatenate the string s1+s1 and then try to find the s2 in the concatenated string if it contains
	 * 
	 *
	 *the second string then second string is the rotation of first
	 **/
	
	public boolean isRotation(String str1, String str2)
	{
		String result = str1+str1;
		if(result.contains(str2))
			return true;
		return false;
	}
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub

	}

}
