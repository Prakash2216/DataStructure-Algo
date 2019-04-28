package com.ds.algo.mathematical;

public class LCM 
{
	public static int gcd(int a, int b)
	{
		if(a == 0 || b == 0)
			return 0;
		if(a == b)
			return a;
		
		return (a%b == 0 ? b : gcd(b, a%b));
				
	}
	
	public static void main(String[] args)
	{
		System.out.println(gcd(3, 0));
		System.out.println("LCM of 3 and 4 is : "+(3*4)/gcd(3, 4));
	}

}