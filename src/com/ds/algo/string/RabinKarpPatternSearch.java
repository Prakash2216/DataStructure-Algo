package com.ds.algo.string;

import java.util.ArrayList;
import java.util.Iterator;

public class RabinKarpPatternSearch {

	private ArrayList<Integer> found = new ArrayList();
	int prime = 3;
	
	private int createHash(char [] arr) {
		
		int hash=0;
		
		for(int i=0; i<arr.length; i++) {
			hash += arr[i]*Math.pow(prime, i); 
		}
		return hash;
	}
	
	private boolean rabinKarp(String str, String pattern) {
		
		// base condition
		if(pattern == null)
			return true;
		if(str == null)
			return false;
		int phash = createHash(pattern.toCharArray());
		int nhash = createHash(str.substring(0, pattern.length()).toCharArray());
		
		boolean flag = false;
		//System.out.println(str.substring(0, pattern.length()));		
	  	
		int i = 0;
		int j = i+pattern.length();
		char [] sarr = str.toCharArray();
		int x=0;
		while(j<=str.length()-pattern.length()) {
			
			if(phash == nhash) {
				flag = true;
				found.add(i);
			}
			x= (nhash-str.charAt(i))/prime;
			nhash =(int)(x + (str.charAt(j))*Math.pow(prime, pattern.length()-1));
			i++;
			j++;
		}
		
		return flag;
	}
	
	public static void main(String[] args) {
		String str = "abdxbacabcyabc";
		String pattern = "abc";
		
		RabinKarpPatternSearch obj = new RabinKarpPatternSearch();
		System.out.println("Pattern Found : ? :"+obj.rabinKarp(str, pattern));
		
		System.out.print("Pattern found at : ");
		Iterator ite = obj.found.iterator();
		while(ite.hasNext()) {
			System.out.print(ite.next()+" ");
		}
	}

}
