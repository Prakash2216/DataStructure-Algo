package com.ds.algo.array;

public class MaximumSumofCotiguousSubarray {

	// Implementing the Kadane's Algorithm
	//Note: This Algo does not handle the situation when all the elements in array are negative.
	private static int maxSum(int arr[], int size){
		int maxSum_So_far=0;
		int maxSum_ending_here=0;
		
		for(int i=0; i<size; i++){
			maxSum_ending_here += arr[i];
			if(maxSum_So_far < maxSum_ending_here)
				maxSum_So_far = maxSum_ending_here;
			if(maxSum_ending_here <  0)
				maxSum_ending_here = 0;
		}
		return maxSum_So_far;		
	}
	
	//Modified version of the Kadane's Algo.
	
	private static int maxSumModified(int arr[], int size){
		int maxSum_so_far = Integer.MIN_VALUE;
		int maxSum_ending_here = 0;
		
		for(int i=0; i<size; i++){
			
			maxSum_ending_here += arr[i];
			if(maxSum_so_far < maxSum_ending_here)
				maxSum_so_far = maxSum_ending_here;
			if(maxSum_ending_here < 0)
				maxSum_ending_here = 0;
		}
		return maxSum_so_far;
	}
	
	public static void main(String[] args) {
		int arr[] ={-2, -3, 4, 1, -2, 7, -1, 9};
		
		System.out.println("Max Sum of the contiguous subarray is :: "+maxSum(arr, arr.length));
		
		int arr1[] ={-2, -3, -4, -1, -2, -7, -1, -9};
		
		System.out.println("Negative arrays Max Sum of the contiguous subarray is :: "+maxSumModified(arr1, arr1.length));
	}

}
