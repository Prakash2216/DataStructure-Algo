package com.ds.alo.sorting;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;

public class BucketSort {

	public static void main(String[] args) 
	{
		double [] arr = {0.897, 0.565, 0.656, 0.1234, 0.665, 0.3434};
		int n = arr.length;
		bucketSort(arr, n);
	}

	private static void bucketSort(double[] arr, int n)
	{
		LinkedList<Double> [] bucket = new LinkedList[n];
		
		for(int i=0; i<n; i++)
		{
			int bi = (int) (n*arr[i]);
			
			if(bucket[bi] == null) 
			{
				bucket[bi] = new LinkedList<>();
				bucket[bi].add(arr[i]);
			}
			else
				bucket[bi].add(arr[i]);
			
			System.out.println(arr[i]+" added in bucket "+bi);
		}
		
		for(int i=0; i<n; i++)
		{
			if(bucket[i] == null)
				continue;			
			Collections.sort(bucket[i]);
		}
		
		System.out.println("\n");
		for(int i=0; i<n; i++)
		{
			if(bucket[i] == null)
				continue;
			Iterator<Double> ite = bucket[i].iterator();
			while(ite.hasNext())
				System.out.print(ite.next()+" ");
		}
		
	}

}
