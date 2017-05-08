package com.ds.algo.interview.amzn.set330;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Rearrange characters in a string so that no character repeats twice. 
 * Input: aaabc 
 * Output: abaca 
 * Input: aa
 * Output: No valid output
 * Input: aaaabc
 * Output: No valid output
 * 
 * @author Prakash Singh.
 *
 */
public class RearranceChartersNoTwoAdjacent {

	private void rearrangeChar(String str) {
		HashMap<Character, Integer> map = new HashMap<>();
		int len = str.length();
		char []aux= new char[len];
		
		//counting each character
		for(int i=0; i<len; i++) {
			char c = str.charAt(i);
			
			if(map.get(c)==null)
				map.put(c, 1);
			else
				map.put(c, map.get(c)+1);
		}
		
		int maxValue = Collections.max(map.values());
		if(maxValue > (len+1)/2) {
			System.out.println("Invalid String");
			return;
		}
		int evenIndex=0;
		int oddIndex=1;
		char k = 0;
		
		while(!map.isEmpty()) {
			int max = Collections.max(map.values());
			
			//Getting the Entry set
			for(Map.Entry<Character, Integer> entry : map.entrySet()) {				
			
				if(max == entry.getValue()) {
					k = entry.getKey();
					break;
				}
			}
			
			while(map.get(k) !=0 ) {
				if(evenIndex < len) {
					aux[evenIndex] =k;
					evenIndex = evenIndex+2;
					
				}
				else if(oddIndex < len) {
					aux[oddIndex]=k;
					oddIndex = oddIndex+2;
				}
				map.put(k, map.get(k)-1);
			}
			map.remove(k);			
		}
		
		System.out.println(aux);
	}
	public static void main(String[] args) {
		//String str ="aaabbc";
		String str ="abc";
		
		RearranceChartersNoTwoAdjacent obj = new RearranceChartersNoTwoAdjacent();
		obj.rearrangeChar(str);
	}

}
