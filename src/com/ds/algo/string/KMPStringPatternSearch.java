package com.ds.algo.string;

import java.util.Arrays;
/**
 * KMP(Knuth -Morris -Pratt) Algo.
 * 
 * In Brute force algorithm, the complexity of finding a substring or pattern in given string is O(n^2).
 * while using KMP the complexity is reduced to O(m+n) where m,n are lenth of string and pattern.
 * 
 * KMP:	KMP uses an auxilary array of length equal to the length of pattern and keep the length of prefix which has of equal length suffix in pattern.
 * @author Prakash Singh
 *
 */
public class KMPStringPatternSearch {

	private void computeLPS(int [] lps, char [] pattern) {
		int i=1;
		int j=0;
		
		while(i < pattern.length) {
			if(pattern[j] == pattern[i]) {
				lps[i] = j+1;
				i++;
				j++;
			}
			else {
				if(j != 0)
					j = lps[j-1];
				else
					i++;
			}
		}
	}
	private boolean KMPPatternSearch(char [] str, char [] pattern) {
		
		int [] lps = new int[pattern.length];
		Arrays.fill(lps, 0);
		computeLPS(lps, pattern);
		
		int i =0; 
		int j=0;
		
		while(i < str.length && j< pattern.length) {
			
			if(str[i] == pattern[j]) {
				i++;
				j++;
			}
			else {
				if(j != 0) {
					j = lps[j-1];
				}
				else {
					i++;
				}
			}
		}
		
		if(j == pattern.length)
			return true;
		
		return false;
	}
	public static void main(String[] args) {
		String str ="abcxabcdabcdabcy";
		String pattern ="abcdabcy";
		
		KMPStringPatternSearch obj = new KMPStringPatternSearch();
		System.out.println(obj.KMPPatternSearch(str.toCharArray(), pattern.toCharArray()));
	}

}
