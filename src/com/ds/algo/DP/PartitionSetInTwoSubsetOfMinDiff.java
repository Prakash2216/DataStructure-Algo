package com.ds.algo.DP;

public class PartitionSetInTwoSubsetOfMinDiff
{
	//Recursive approach
	public static int partitionIntoMinDiff(int [] arr, int i, int subsetSum, int totalSum)
	{
		if(i == 0)
			return Math.abs((totalSum - subsetSum) - subsetSum);
		
		return Math.min(partitionIntoMinDiff(arr, i-1, subsetSum+arr[i-1], totalSum), partitionIntoMinDiff(arr, i-1, subsetSum, totalSum));
	}
	
	public static void main(String[] args) 
	{
		int [] arr = {3, 2, 1, 2, 4, 1};
		int n = arr.length;
		int sum=0;
		for(int i=0; i<n; i++)
		{
			sum+=arr[i];
		}
		System.out.println("Min diff of two subsets : "+partitionIntoMinDiff(arr, n, 0, sum));
	}

}
