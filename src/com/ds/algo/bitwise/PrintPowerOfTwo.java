package com.ds.algo.bitwise;
/**
 * WAP to print the power of 2 for a given no.
 * 
 * 
 * input : a number is input 9 
 * Output : 3 0
 * 
 * Explanation: 9 --> 2^3, 2^0
 * 				11 --> 2^3, 2^1, 2^0
 *  
 * Approach:
 * 			Convert the decimal no. into binary no. and print the index if the value at index is 1 in reverse order.
 * 			
 * @author 1019270
 *
 */
public class PrintPowerOfTwo 
{
	public static void getPowers(int n)
	{
		// for storing the no. into 32 bit array
		int [] bit = new int[32];
		int i=0;
		
		while(n > 0)
		{
			bit[i]=n%2;
			n = n/2;
			i++;
		}
		
		for(int j = i-1; j>=0; j--)
		{
			if(bit[j] == 1)
				System.out.print(j+" ");
		}
	}
	public static void main(String[] args) {
		getPowers(9);
	}

}
