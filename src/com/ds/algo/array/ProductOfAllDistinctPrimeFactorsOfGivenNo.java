package com.ds.algo.array;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
/**
 * .Find product of distinct prime factor of all numbers .
Ex- 1
3
10
12
7
prime factor of 10 = 2*5
prime factor of 12 = 2*2*3
prime factor of 7 = 7

SO distinct prime factor is 2*5*3*7 = 210
output -210


 * @author 1019270
 *
 */
public class ProductOfAllDistinctPrimeFactorsOfGivenNo {

	private void findPrimeFactors(int []arr){
		Set<Integer> s = new HashSet<>();
		
		for(int i=0; i<arr.length; i++){
			primeFactors(arr[i], s);
		}
		
		Iterator<Integer> ite = s.iterator();
		int prod =1;
		while(ite.hasNext()){
			prod*=ite.next();
		}
		System.out.println(prod);
	}
	private void primeFactors(int n, Set<Integer> s) {
		
		while(n%2 == 0){
			s.add(2);
			n/=2;
		}
		for(int i=3; i<=Math.sqrt(n); i=i+2){
			while(n%i == 0){
				s.add(i);
				n/=2;
			}
		}
		if(n>2)
			s.add(n);
	}
	public static void main(String[] args) {
		int []arr ={10, 12, 7};
		ProductOfAllDistinctPrimeFactorsOfGivenNo obj = new ProductOfAllDistinctPrimeFactorsOfGivenNo();
		obj.findPrimeFactors(arr);
	}

}
