package com.ds.algo.DP;
/**
 * Subset Sum Problem: Given a set of non-negative integers and a sum.
 * find if there is a subset of the given set with sum equal to the given sum.
 * 
 * @author 1019270
 *
 */
public class FindSubsetOfGivenSum {

	//Recursive approach
	public static boolean findSubset(int []arr, int i, int subsetsum, int sum)
	{
		// Base condition
		if(i == 0)
			return false;
		if( subsetsum == sum)
			return true;
		
		return (findSubset(arr, i-1, subsetsum+arr[i], sum) || findSubset(arr, i-1, subsetsum, sum));
	}
	
	public static void main(String[] args) {
		
		int [] arr = {3, 34, 4, 12, 5, 2};
		System.out.println(findSubset(arr, arr.length-1, 0, 9));
	}

}
