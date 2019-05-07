package com.ds.algo.string;

public class PrintLongestPalindromeOfTwoStrings {
	
	public static StringBuffer longestPalindrome=null;
	public void printPalindrome(String str1, String str2)
	{
		if(str1 == null || str2 == null)
			return;
		StringBuffer buffer = new StringBuffer();
		longestPalindrome(str1, str2, str1.length(), str2.length(), 0,  buffer);
	}

	private void longestPalindrome(String str1, String str2, int len1, int len2, int i, StringBuffer buffer) {
		
		if(len1 <=0 || len2 <= 0)
		{
			if(longestPalindrome != null)
			{
				if(longestPalindrome.length() < buffer.length())
					longestPalindrome = buffer;
			}
			else
				longestPalindrome = buffer;
			buffer = new StringBuffer();
			return ;
		}
		
		if(str1.charAt(len1-1) == str2.charAt(len2-1))
		{
			buffer.append(str1.charAt(len1-1));
			longestPalindrome(str1, str2, len1-1, len2-1, i, buffer);
		}
		else
		{
			if(buffer.length() != 0)
			{
				if(longestPalindrome == null) 
				{
					longestPalindrome = buffer;
					
				}
				else if( longestPalindrome.length() < buffer.length())
				{
					longestPalindrome = buffer;
				}
				buffer= new StringBuffer();
			}
			longestPalindrome(str1, str2, len1-1, len2, i, buffer);
			longestPalindrome(str1, str2, len1, len2-1, i, buffer);
		}
	}

	public static void main(String[] args) {
		String s1 = "ababd";
		String s2 = "dbaba";
		
		PrintLongestPalindromeOfTwoStrings obj = new PrintLongestPalindromeOfTwoStrings();
		obj.printPalindrome(s1, s2);
		System.out.println(obj.longestPalindrome.toString());
	}

}
