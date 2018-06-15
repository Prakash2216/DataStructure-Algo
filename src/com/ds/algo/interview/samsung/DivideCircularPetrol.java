package com.ds.algo.interview.samsung;

import java.util.HashMap;
import java.util.Map;

public class DivideCircularPetrol
{
	
	public static void main(String[] args) 
	{
		int [] petrol = {5, 3, 9, 3, 6};
		int n = petrol.length;
		int m = 4;
		divide(petrol, n, m);
	}

	private static void divide(int[] petrol, int n, int m) 
	{
		int mean =0;
		for(int i=0; i<n; i++)
			mean = mean+petrol[i];
		
		mean = mean/m;
		int [] temp = null;
		//Map<Integer, int []> map = new HashMap<>();
		int minDev = Integer.MAX_VALUE;
		int k;
		for(int i =0; i<n; i++)
		{
			int[] arr = new int[m];
			int dev =0;
			int tSum =0;
			k=0;
			tSum = arr[k] = petrol[i];
			
			for(int j =(i+1)%n; j != i; j=(j+1)%n)
			{
				tSum = tSum+petrol[j];
				
				if(tSum < mean)
				{
					arr[k] = tSum;
				}
				else 
				{
					if(Math.abs(mean - tSum) < Math.abs(mean - arr[k]))
					{
						arr[k] = tSum;
					}
					else
					{
						if(k < m-1)
							arr[++k] = petrol[j];
						else
							arr[k] = petrol[j];
						tSum = arr[k];
					}	
					//dev += Math.abs(mean - arr[k]);
				}
			}
			for(int j=0; j<m; j++)
			{
				dev += Math.abs(mean - arr[j]); 
			}
			if(dev < minDev)
			{
				minDev = dev;
				//map.put(dev, arr);
				temp = arr;
			}
		}
		
		//int [] temp = map.get(minDev);
		for(int i=0; i< temp.length; i++)
		{
			System.out.print(temp[i]+" ");
		}
	}

}
