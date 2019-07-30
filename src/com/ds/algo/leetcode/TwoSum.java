package com.ds.algo.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * Example:
 * Given nums = [2, 7, 11, 15], target = 9,
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 * 
 * Difficulty : EASY
 * 
 * @author lightster
 *
 */


public class TwoSum 
{
	/*
	 * Approach 1:  
	 * In this approach we use the extra space of size array. We create a lookup using map.
	 * Then iterate over the array and check by taking the compliment of target - nums[i].
	 * if this compliment exist we return the i and compliments index. 
	 * 
	 * Complexity:
	 * space = O(n)
	 * time = O(n);
	 * But it takes two iteration of array one during the creation of lookup and another for finding the compliment.
	 *  
	 */
	
	public static int [] twoSum(int [] nums, int target)
	{
		int len = nums.length;
		Map<Integer, Integer> lookup = new HashMap<Integer, Integer>();
		
		for(int i=0; i<len; i++)
		{
			lookup.put(nums[i], i);
		}
		
		for(int j=0; j< len; j++)
		{
			int compliment = target - nums[j];
			Integer index  = lookup.get(compliment);
			
			if(index != null && compliment != j) 	// (compliment != j) if for checking the same number e.g target is 6 and array {3, 2, 4} if this condition is not there it will give {0, 0} 3 used two times.
			{
				return new int[] {j, index};
			}			
		}
		throw new IllegalArgumentException("No two sum solution");
	}
	
	/**
	 * Approach 2 :
	 * This approach in improvement of approach 1. 
	 * In this approach, instead of iterating two times, we check the compliment during the creation of lookup.
	 * we put the compliment in lookup and the earlier index.
	 * @param args
	 */
	
	public static int [] twoSumOptimized(int [] nums, int target)
	{
		int len = nums.length;
		Map<Integer, Integer> lookup = new HashMap<>();
		
		for(int i =0; i<len; i++)
		{
			int compliment = target - nums[i];
			
			if(!lookup.containsKey(compliment))
				lookup.put(nums[i], i);
			else
				return new int [] {lookup.get(compliment), i};
		}
		throw new IllegalArgumentException("No two sum solution");
	}
	
	public static void main(String[] args) 
	{
		int [] arr = {3, 2, 4};
		System.out.println("Approach 1 : "+twoSum(arr, 6));
		System.out.println("Approach 2 : "+twoSumOptimized(arr, 6));
	}

}
