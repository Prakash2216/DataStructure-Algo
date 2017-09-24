package com.ds.alo.sorting;
/**
 * Counting sort is a sorting technique based on keys between a specific range. 
 * It works by counting the number of objects having distinct key values (kind of hashing). 
 * Then doing some arithmetic to calculate the position of each object in the output sequence.
 * 
 * Time Complexity: O(n+k) where n is the number of elements in input array and k is the range of input.
	Auxiliary Space: O(n+k)

Points to be noted:
1. Counting sort is efficient if the range of input data is not significantly greater than the number of objects to be sorted. Consider the situation where the input sequence is between range 1 to 10K and the data is 10, 5, 10K, 5K.
2. It is not a comparison based sorting. It running time complexity is O(n) with space proportional to the range of data.
3. It is often used as a sub-routine to another sorting algorithm like radix sort.
4. Counting sort uses a partial hashing to count the occurrence of the data object in O(1).
5. Counting sort can be extended to work for negative inputs also.
 */
import java.util.Arrays;

public class CountingSort {
	
	public static void _countingSort(int [] arr){
		int n = arr.length;
		int [] count = new int[9];
		int [] output = new int[n];
		
		//initializing the count array as zero
		Arrays.fill(count, 0);
		
		//counting the occurrence of the elements of the arr
		for(int i=0; i<n; i++)
			count[arr[i]]++;
		
		//chance count[i] so that count[i] can contain the actual position of element in output array
		for(int j=1; j<9; j++)
			count[j] += count[j-1];
		
		//putting the element in its actual sorted position
		for(int i=0; i<n; i++){
			output[count[arr[i]]-1] = arr[i];
			count[arr[i]]--;
		}
		//copy output array in original input array
		for(int i=0; i<n; i++)
			arr[i]=output[i];
	}
	
	public static void printArrays(int [] arr)
	{
		int n= arr.length;
		for(int i=0; i<n; i++)
			System.out.print(arr[i]+" ");
		System.out.println("\n");
	}
	//Driver method
	public static void main(String[] args) {
		int [] arr = {0, 1, 4, 1, 2, 7, 5, 2};
		
		System.out.println("Print array Before sorting");
		printArrays(arr);
		System.out.println("Print array using counting Sort");
		_countingSort(arr);
		printArrays(arr);
	}

}
