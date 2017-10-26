package com.ds.algo.interview.amzn.set330;

/**
 * Trapping Rain Water
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.

Examples:

Input: arr[]   = {2, 0, 2}
Output: 2
Structure is like below
| |
|_|
We can trap 2 units of water in the middle gap.

Input: arr[]   = {3, 0, 0, 2, 0, 4}
Output: 10
Structure is like below
     |
|    |
|  | |
|__|_| 
We can trap "3*2 units" of water between 3 an 2,
"1 unit" on top of bar 2 and "3 units" between 2 
and 4.  See below diagram also.

Input: arr[] = [0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1]
Output: 6
       | 
   |   || |
_|_||_||||||
Trap "1 unit" between first 1 and 2, "4 units" between
first 2 and 3 and "1 unit" between second last 1 and last 2 
 * @author 1019270
 *
 */

/**
 * Approach: 1. Simple Aprroach
 * A Simple Solution is to traverse every array element and find the highest bars on left and right sides.
 * Take the smaller of two heights. The difference between smaller height and height of current element is the amount of water
 * that can be stored in this array element. Time complexity of this solution is O(n2).
 * @author 1019270
 *
 */
/**
 * Approach: 2 
 * An Efficient Solution is to pre-compute highest bar on left and right of every bar in O(n) time. 
 * Then use these pre-computed values to find the amount of water in every array element. 
 * @author 1019270
 *
 */
public class TrapWaterProblem {

	//Approach 1: Simple approach implementation O(n^2)
	public void trapRainWater(int [] arr, int length){
		
		int sum=0;
		for(int i=0; i < length; i++){
			
			int leftHighestBar = getLeftHigestBar(arr, i, length);
			int rightHighestBar = getRightHigestBar(arr, i, length);
			
			int small = Math.min(leftHighestBar, rightHighestBar);
			
			sum = sum+(small - arr[i]);
		}
		System.out.println("The amount of water Trapped in Bars :: "+sum);
	}
	public int getRightHigestBar(int[] arr, int i, int length) {
		int maxHeight =0;
		for(int j=i; j<length; j++){
			if(maxHeight < arr[j])
				maxHeight = arr[j];
		}
		return maxHeight;
	}
	public int getLeftHigestBar(int[] arr, int i, int length) {
		
		int maxHeight =0;
		for(int j=i; j>=0; j--){
			if(maxHeight < arr[j])
				maxHeight = arr[j];
		}
		return maxHeight;
	}
	
	//Aproach 2: Time complexity O(n) space complexity O(n)
	
	public void trapRainWaterEfficient(int []arr, int length){
		int sum =0;
		int left[] = new int[length];
		int right[] = new int[length];
		
		//Assigning Max height bar on left of the ith bar
		left[0] = arr[0];
		for(int i =1; i<length; i++)
			left[i] = Math.max(left[i-1], arr[i]);
		
		// Assigning the Max height bar on right of the ith bar
		right[length-1] = arr[length-1];
		for(int j=length-2; j>=0; j--)
			right[j] = Math.max(right[j+1], arr[j]);
		
		//Now calculating the maximum water trapped in bars
		for(int i=0; i<length; i++)
			sum = sum+Math.min(left[i], right[i])-arr[i];
		
		System.out.println("The total Trapped Water :: "+sum);
		
	}
	
	public static void main(String[] args) {
		
		int arr[]   = {2, 0, 0, 3, 0, 4};
		int l = arr.length;
		TrapWaterProblem tp = new TrapWaterProblem();
		System.out.println("Simple Approach ::");
		tp.trapRainWater(arr, l);
		System.out.println("Efficient Approach ::");
		tp.trapRainWaterEfficient(arr, l);
	}

}
