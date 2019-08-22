package com.ds.algo.array;
/**
 * @Date 16/05/2019
 * @author Prakash2216
 *
 *This question was asked in an interview.
 *
 *Given a unique positive integer array with elements ranging from 0 to length-1.
 *WAP to interchange the element value and its corresponding indexed value.
 *
 *Ex. input :	[3, 2, 0, 1]	here a[0] = 3 in iput so interchaged a[3]=0; similarly for a[1]=2 the in output a[2]=1;
 *	  output :	[2, 3, 1, 0] 
 *
 *Approach : 
 *We solve this problem using the hopcount strategy in which jump to the index at current index value save that value at temp var and copy the 
 *value of the previous index and keep jumping upto the count not reaches to the len. since in len jumps will interchange all the values with index.
 *
 *There is a scenario when before changing all the values with index it gets into the loop by again traversing the same index already exchanged.
 *Ex. [7, 6, 5, 4, 0, 1, 2, 3] after exchanging upto like [ ,  ,  , 7, 4 ,  ,  , 0];
 *once we reach the index 4 has value 0 again when we go to index 0 has value 7 which already been processed. 
 *so solving that at the start of process we choose that value and mark it with negative no to remember as starting point. if at all before traversing all
 *if we reach again to starting point by changing its value, we increment index++ for next element and again mark that index value as starting and proceed further.
 */
public class SwapArrayIndex 
{
		public static void swapArr(int [] a,  int len)
		{
			int count =0;
			int index = a[0];
			a[0] = -a[0]; 		// Marking as negative for starting point.
			int value = 0;
			
			while(count<len)		// jump upto all the elements are processed once
			{
				if(a[index] < 0)	// checking if there is loop before processing all the elements
				{
					a[index]=value; // change that value and check the the count with length if processed the no need to traverse furhter.
					count++;
					if(count<len)
					{
						index++;
						value = index;
						index = a[index];
						a[value] = -a[value];
					}
				}
				else
				{
					int temp = a[index];	// Swap the index and jump to next index.
					a[index] = value;
					value = index;
					index = temp;
					count++;
				}
			}
			
			for(int i=0; i<len; i++)
			{
				System.out.print(a[i]+" ");
			}
		}
		public static void main(String[] args)
		{
			//int [] a = {4, 3, 0, 5, 1, 2};
			int [] a = {7, 6, 5, 4, 0, 1, 2, 3};
			swapArr(a, a.length);
			System.out.println("\ndone");
		}
}


