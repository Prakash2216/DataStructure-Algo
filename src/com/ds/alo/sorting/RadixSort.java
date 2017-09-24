package com.ds.alo.sorting;

import java.util.Arrays;

public class RadixSort {

	public static void main(String[] args) {
		int arr[] = {170, 45, 75, 90, 802, 24, 2, 66};
        int n = arr.length;
        radixsort(arr, n);
        print(arr, n);
	}

	private static void radixsort(int[] arr, int n) {
		int max = getMax(arr, n);
		
		for(int exp=1; (max/exp)>0; exp*=10)
			_radixSortUtil(arr, n, exp);
	}
	
	private static void _radixSortUtil(int[] arr, int n, int exp) {
		int []buffer = new int[n];
		int []count = new int[10];
		
		//Assigning 0 to the count array
		Arrays.fill(count, 0);
		
		for(int i=0; i<n; i++){
			count[(arr[i]/exp)%10]++;
		}
		
		for(int j=1; j<10; j++)
			count[j] += count[j-1];
		
		for(int k=n-1; k>=0; k--){
			buffer[count[(arr[k]/exp)%10]-1] = arr[k];
			count[(arr[k]/exp)%10]--;
		}
		//copy buffer data to original array
		for(int i=0; i<n; i++)
			arr[i] = buffer[i];
	}

	private static int getMax(int[] arr, int n) {
		int max = arr[0];
		for(int i=1; i<n; i++)
			if(max<arr[i])
				max=arr[i];
		return max;
	}

	private static void print(int[] arr, int n) {
		for(int i=0; i<n; i++)
			System.out.print(arr[i]+" ");
	}
}
