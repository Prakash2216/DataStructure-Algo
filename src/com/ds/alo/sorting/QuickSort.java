package com.ds.alo.sorting;

public class QuickSort {

	public void qSort(int []arr, int start, int end){
		if(start < end){
			int p = partition(arr, start, end);
			
			qSort(arr, start, p-1);
			qSort(arr, p+1, end);
		}
	}
	private int partition(int[] arr, int l, int r) {
		// selecting last element as pivot element
		int piv = arr[r];
		int i, j;
		i=l-1;
		for(j =l; j<r; j++){
			if( arr[j] < piv ){
				i++;
				exchange(arr, i, j);
			}				
		}
		exchange(arr, i+1, r);
		return i+1;
	}
	private void exchange(int[] arr, int i, int r) {
		int temp = arr[i];
		arr[i] = arr[r];
		arr[r] = temp;		
	}
	
	public void printArray(int []arr, int n){
		for(int i=0; i<n; i++){
			System.out.print(arr[i]+" ");
		}
	}
	public static void main(String[] args) {
		int [] arr = {1, 4, 1, 2, 7, 5, 2};
		int n = arr.length;
		QuickSort qobj = new QuickSort();
		System.out.println("Array before sorting");
		qobj.printArray(arr, n);
		System.out.println("\n");
		qobj.qSort(arr, 0, n-1);
		System.out.println("Array after Quicksorting \n");
		qobj.printArray(arr, n);
	}

}
