package com.ds.algo.array;

import java.util.Arrays;

/**
 * Given a permutation of first n natural numbers as array and an integer k.
 * Print the lexicographically largest permutation after at most k swaps
 * 
 * Ex: Input: arr[] = {4, 5, 2, 1, 3}, k = 3.
 * Output: 5 4 3 2 1
 * Explanation:
 * Swap 1st and 2nd elements: 5 4 2 1 3
 * Swap 3rd and 5th elements: 5 4 3 1 2 
 * Swap 4th and 5th elements: 5 4 3 2 1 
 * Input: arr[] = {2, 1, 3}, k = 1.
 * Output: 3 1 2
 * @author Panna
 *
 */
public class LargestPermutationAfterKswap {

	public void swap(int a, int b) {
		int t = a;
		a=b;
		b=t;
	}
	public void largestPermutationKswap(int []arr, int n, int k) {
		int []pos = new int[n+1];
		
		for(int i=0; i<n; i++) {
			pos[arr[i]]=i;
		}
		
		for(int i=0; i<n && k>0; i++) {
			
			if(arr[i] == n-i)
				continue;
			
			int temp = pos[n-i];
			pos[arr[i]]=pos[n-i];
			pos[n-i] =i;
			
			//swap(arr[temp], arr[i]);
			int l = arr[temp];
			arr[temp] = arr[i];
			arr[i] = l;
			
			k--;
		}
	}
	public static void main(String[] args) {
		int [] arr = {4,5,2,1,3};
		int n= arr.length;
		LargestPermutationAfterKswap obj = new LargestPermutationAfterKswap();
		obj.largestPermutationKswap(arr, n, 3);
		
		for(int i=0; i<n; i++) {
			System.out.print(arr[i]+" ");
		}
	}

}
