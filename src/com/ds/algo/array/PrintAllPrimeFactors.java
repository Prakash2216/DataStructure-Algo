package com.ds.algo.array;
/**
 * Efficient program to print all prime factors of a given number.
 * Given a number n, write an efficient function to print all prime factors of n. 
 * For example, if the input number is 12, then output should be “2 2 3”. 
 * And if the input number is 315, then output should be “3 3 5 7”.
 * 
 * @author 1019270
 *
 */
public class PrintAllPrimeFactors {
	private void findPrimeFactors(int n){
		while(n%2 == 0){
			System.out.print(2+" ");
			n/=2;
		}
		
		for(int i=3; i<=Math.sqrt(n); i=i+2){
			while(n%i == 0){
				System.out.print(i+" ");
				n/=i;
			}
		}
		if(n>2)
			System.out.print(n+" ");
	}
	public static void main(String[] args) {
		int n=400;
		PrintAllPrimeFactors obj = new PrintAllPrimeFactors();
		obj.findPrimeFactors(n);
	}

}
