package com.ds.algo.array;

public class Sort012 {

	public static void print(int [] arr)
	{
		for(int i=0; i<arr.length; i++)
			System.out.print(arr[i]+" ");
	}
	
	public static void main(String[] args) 
	{
		int [] arr = {2,1,0,1,0,0,2,1,0,1,1,2,0,1,0,2,0,1,0};
		int n = arr.length;
		
		int l=0, m=0, h=n-1;
		
		while(m<=h)
		{
			if(arr[m] == 0)
			{
				if(arr[l] == 0 && l == m)
				{
					l++;
					m++;
				}
				else if(arr[l] == 0 && l != m)
					l++;
				else
				{
					int temp = arr[l];
					arr[l] = arr[m];
					arr[m] = temp;
					l++;
					m++;
				}
				
			}
			else if(arr[m] == 1)
				m++;
			else if(arr[m] == 2)
			{
				if(arr[h] == 2)
					h--;
				else
				{
					int temp = arr[m];
					arr[m] = arr[h];
					arr[h] = temp;
					h--;
				}				
			}
		}	
		print(arr);
	}

}
