package com.ds.algo.array;

public class PrintAllPermutation {

	public void swap(char [] arr, int p, int q) {
		char temp = arr[p];
		arr[p] = arr[q];
		arr[q] = temp;
	}
	public void permutation(char [] arr, int l, int r) {
		if( l == r)
			System.out.println(arr);
		
		for(int i=l; i<=r; i++) {
			swap(arr, l, i);
			permutation(arr, l+1, r);
			swap(arr, l, i);
		}
	}
	public static void main(String[] args) {
		String name = "ABBC";
		char [] arr = name.toCharArray();
		int r = arr.length-1;
		PrintAllPermutation obj = new PrintAllPermutation();
		obj.permutation(arr, 0, r);
	}

}
