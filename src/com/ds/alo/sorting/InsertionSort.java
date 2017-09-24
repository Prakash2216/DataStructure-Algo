package com.ds.alo.sorting;

public class InsertionSort {

	public void _insertionSort(int [] arr, int n){
		int temp;
		int j;
		for(int i=1; i<n; i++){
			
			temp = arr[i];
			
			for(j=i; j>0 && arr[j-1] > temp; j--)
				arr[j] = arr[j-1];
			arr[j]= temp;
		}
	}
	public void printArray(int []arr, int n){
		for(int i=0; i<n; i++){
			System.out.print(arr[i]+" ");
		}
	}
	public static void main(String[] args) {
		int [] arr = {1, 4, 1, 2, 7, 5, 2};
		
		InsertionSort ins = new InsertionSort();
		System.out.println("Print array before sorting\n");
		ins.printArray(arr, arr.length);
		System.out.println("\n");
		System.out.println("Print array after sorting\n");
		ins._insertionSort(arr, arr.length);
		ins.printArray(arr, arr.length);
	}

}
