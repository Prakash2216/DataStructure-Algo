package com.ds.algo.interview.amzn.set330;

/*
 * Given an array. How can we find sum of elements in index interval (i, j) in constant time. You are allowed to use extra space.
 * Example: A: 3 2 4 7 1 -2 8 0 -4 2 1 5 6 -1
 * length = 14
 */
public class FindGivenIntervalSumInConstTime {

	private Integer findSum(int []arr, int p, int q ) {
		
		if(arr == null)
			return null;
		int [] aux = new int[arr.length];
		aux[0]=arr[0];
		
		for(int i=1; i<arr.length; i++) {
			aux[i] = aux[i-1]+arr[i];
		}
		
		return aux[q]-aux[p-1];
	}
	public static void main(String[] args) {
		int [] arr = {3, 2, 4, 7, 1, -2, 8, 0, -4, 2, 1,5,6,-1};
		
		FindGivenIntervalSumInConstTime obj = new FindGivenIntervalSumInConstTime();
		System.out.println(obj.findSum(arr, 2, 5));
	}

}
