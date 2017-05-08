package com.ds.algo.interview.amzn.set330;

public class CountNoOfDigitAndChar {

	private void prichCount(String str) {
		if(str == null)
			return;
		
		int countDigit=0;
		int countChar=0;
		for(int i=0; i<str.length(); i++) {
			char c = str.charAt(i);
			if((c>='a' && c<='z') ||(c>='A' && c<='Z'))
				countChar++;
			else if(Character.getNumericValue(c) >=0 && Character.getNumericValue(c)<=9)
				countDigit++;
		}
		System.out.println("character in string are : "+countChar);
		System.out.println("No. of digits in string are : "+countDigit);
	}
	public static void main(String[] args) {
		String s ="a5$45NdG";
		CountNoOfDigitAndChar obj = new CountNoOfDigitAndChar();
		obj.prichCount(s);
	}

}
