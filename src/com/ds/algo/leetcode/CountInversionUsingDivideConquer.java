package com.ds.algo.leetcode;

public class CountInversionUsingDivideConquer 
{
	
	public int countInversion(int []arr, int l, int h)
	{
		int count=0;
		
		if(l < h)
		{
			int mid = (l+h)/2;
		    count = countInversion(arr, l, mid);
		    count += countInversion(arr, mid+1, h);
		    count += merge(arr, l, mid, h);
		}
		return count;
	}
	
	private int merge(int[] arr, int l, int mid, int h) 
	{
		int [] B = new int[h-l+1];
		int i =l;
		int j =mid+1;
		int k=0;
		int count =0;
		
		while(i <= mid && j<=h)
		{
			if(arr[i] <= arr[j])
			{
				B[k++] = arr[i++];
			}
			else
			{
				B[k++] = arr[j++];
				count = count+(mid+1-i);
			}
		}
		
		while( i <= mid)
			B[k++] = arr[i++];
		
		while( j <= h)
		{
			B[k++] = arr[j++];
		}
		
		for(int m = 0; m<k; m++ )
		{
			arr[l++] = B[m];
		}
		return count;
	}
	public static void main(String[] args) 
	{
		int [] arr = {2, 5, 3, 1, 10};
		
		CountInversionUsingDivideConquer obj = new CountInversionUsingDivideConquer();
		
		int count = obj.countInversion(arr, 0, arr.length-1);
		
		for(int i=0; i<arr.length; i++)
		{
			System.out.print(arr[i]+" ");
		}
		System.out.println("\n"+count);
	}

}
