package com.ds.algo.array;
/**
 * WAP to find the maximum sum of non-contiguous subarray.
 * 
 *Ex: input: arr={4, 1, 1, 4, 2, 1};
 *	output: 9
 *
 *Approach: In this approach we have two variable inclSum which has the sum including the element at index, while exclSum has the sum till
 * index-1, and next inclSum will be max of inclSum and exclSum+arr[i], and exclSum will be last inclSum.
 * 
 * @author Prakash Singh
 *
 */
public class MaximumSumofNonContiguousSubarray {

	private static int maxSum(int [] arr, int n){
		if(n==0)
			return 0;
		
		int inclSum=arr[0];
		int exclSum=0;
		for(int i=1; i<n; i++){
			int temp = inclSum;
			inclSum =Math.max(inclSum, exclSum+arr[i]);
			exclSum = temp;
		}
		
		return inclSum;
	}
	public static void main(String[] args) {
		int [] arr ={4, 1, 1, 4, 2, 1};
		int n = arr.length;
		
		System.out.println("Maximum sum of non-contiguous subarray is :: "+maxSum(arr, n));
	}

}
