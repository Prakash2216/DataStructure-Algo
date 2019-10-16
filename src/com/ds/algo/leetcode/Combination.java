package com.ds.algo.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Combination {

	public void combination(int [] arr, int target, ArrayList<Integer> result, int sum, int k)
	{
		if(sum == target)
		{
			System.out.println(result);
			return;
		}
		if(sum > target)
		{
			return;
		}
		
		for(int i=0; i<arr.length; i++)
		{
			result.add(k, arr[i]);
			combination(arr, target, result, sum+arr[i], k+1);
			result.remove(k);
		}
	}
	public static void main(String[] args) 
	{
		int [] arr = {2,2,3,6,7};
		int target =7;
		int k=0;
		int sum=0;
		ArrayList<Integer> result = new ArrayList<>();
		Combination obj = new Combination();
		obj.combination(arr, target, result, sum, k);
		System.out.println("done");

	}

}
