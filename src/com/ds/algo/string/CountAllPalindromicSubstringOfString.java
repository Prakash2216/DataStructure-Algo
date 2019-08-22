package com.ds.algo.string;

public class CountAllPalindromicSubstringOfString 
{

	public static int countString(String s)
	{
		int N = s.length();
		int ans=0;
		int l = 2*N-1;
		for(int center=0; center<l; ++center)
		{
			int left = center/2;
			int right = left+center%2;
			while((left>=0 && right < N) && (s.charAt(left) == s.charAt(right)))
			{
				ans++;
				left--;
				right++;
			}
		}
		return ans;
	}
	public static void main(String[] args) {
		
		String s = "abc";
		System.out.println(countString(s));

	}

}
