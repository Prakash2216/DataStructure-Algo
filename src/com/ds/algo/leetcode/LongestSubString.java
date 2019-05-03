package com.ds.algo.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string, find the length of the longest substring without repeating characters.
 * Example 1:
 * Input: "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * 
 * Example 2:
 * 
 * Input: "bbbbb"
 * 
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * 
 * Example 3:
 * Input: "pwwkew"
 * 
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * 
 * Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
             
 * @author lightster
 *
 */
public class LongestSubString {

	public static int lengthOfLongestSubstring(String s) 
    {
        int max= 0;
        Map<Character, Integer> map = new HashMap<>();
        int count = 0;
        
        for(int i=0, j=0; j< s.length(); )
        {
            char c = s.charAt(j);
            
            if(map.get(c) == null)
            {
                map.put(c, 1);
                count++;
                j++;
            }
            else
            {
                if(max < count)
                    max = count;
                map.remove(s.charAt(i));
                count--;
                i++;
            }
        }
        return (max<count ? count : max);
    }
	public static void main(String[] args) 
	{
		String str = "abcabcbb";
		System.out.println("length of longest substring : "+lengthOfLongestSubstring(str));
	}

}
