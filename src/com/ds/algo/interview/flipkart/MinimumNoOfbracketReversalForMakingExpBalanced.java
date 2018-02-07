package com.ds.algo.interview.flipkart;

import java.util.Stack;

/**
 * Minimum number of bracket reversals needed to make an expression balanced 
 * Given an expression with only ‘}’ and ‘{‘. The expression may not be balanced.
 * Find minimum number of bracket reversals to make the expression balanced.
 * 
 * @author Prakash2216
 *
 *
 *Approach: 1. Remove the balanced brackets.
 *			2. if M is no. of closing bracket and N is the no of opening brackets.
 *			3. Min no. of reversal is ceil(M/2)+ceil(n/2)=(m+n)/2+n%2
 *
 */
public class MinimumNoOfbracketReversalForMakingExpBalanced 
{
	static int countMinReversal(String exp)
	{
		int len = exp.length();
		/*
		 * Length of expression should be even to make it
		 * balanced by reversal.
		 */
		if(len%2 != 0)
			return -1;
		
		/*
		 * After this loop stack will contain unbalanced set of expression.
		 * i.e "}}..{{..}{"
		 */
		Stack<Character> stk = new Stack<>();
		for(int i=0; i<len; i++)
		{
			char c = exp.charAt(i);
			if(c=='}' && !stk.empty())
			{
				if(stk.peek() == '{')
					stk.pop();
				else
					stk.push(c);
			}
			else
				stk.push(c);
		}
		// redundent_len = (M+N)
		int redundent_len = stk.size();
		
		/*
		 * Counting the no. of opening brackets. notes after removal of balanced brackets 
		 * there will all opening brackets will be at the end of exp. 
		 */
		int N =0;
		while(!stk.isEmpty() && stk.peek() == '{')
		{
			stk.pop();
			N++;
		}
		return redundent_len/2+N%2;
	}
	public static void main(String[] args) {
		
		String exp ="}{{}}{{{";
		int c=countMinReversal(exp);
		System.out.println(c);
	}

}
