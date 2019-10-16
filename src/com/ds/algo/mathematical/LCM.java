package com.ds.algo.mathematical;
/**
 * 
 * Date : 3/5/2019
 * @author Prakash Singh
 *
 * Find the LCM of the two given numbers a and b.
 * 
 * Approach : Since we know that lcm(a, b)*gcd(a, b) = (a*b).
 */
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
	
	public static int gcd1(int a, int b)
	{
		if(a == 0 || b == 0)
			return 0;
		return (a%b == 0)? b : gcd(b, a%b);
	}
	public static void main(String[] args)
	{
		System.out.println(gcd1(4, 4));
		int gcd = gcd1(3, 2);
		if(gcd != 0)
			System.out.println("LCM of 3 and 2 is : "+(3*2)/gcd1(3,2));
		else
			System.out.println(0);
	}

}
