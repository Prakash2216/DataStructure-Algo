package com.ds.algo.array;

import java.util.Stack;

/**
 * Create your own stack with getMin() method which returns the min in O(1).
 * 
 * Approach: There could be 2 solution for this problem.
 * 
 * 1. By using 2 stacks using O(n) extra space.
 * 2. By using constant space. We are implementing the 2nd approach.
 * 
 * @author 1019270
 *
 */

class MyStack
{
	private Stack<Integer> s;
	private int minElm=0;
	
	public MyStack()
	{
		s = new Stack<>();
	}
	
	public void push(int x)
	{
		if(s.isEmpty())
		{
			minElm = x;
			s.push(x);
			System.out.println("Inserted : "+x);
			return;
		}
		
		if(x < minElm)
		{
			s.push(2*x - minElm);
			minElm = x;
		}
		else
			s.push(x);
		System.out.println("Inserted : "+x);
	}
	
	public Integer pop()
	{		
		if(s.isEmpty())
		{
			System.out.println("Stack is Empty.");
			return null;
		}
		Integer y = s.pop();
		
		if(y < minElm)
		{
			int temp = minElm;
			minElm = (2*minElm - y);
			return temp;
		}
		else
			return y;
	}
	
	public Integer peek()
	{
		if(s.isEmpty())
		{
			System.out.println("Stack is Empty");
			return null;
		}
		
		Integer y = s.peek();
		
		// if peek element y is less than minElm means minElm is the top element.
		if(y < minElm)
		{
			return minElm;
		}
		else
			return y;
	}
	
	public Integer getMin()
	{
		if(s.isEmpty()) 
		{
			System.out.println("Stack is Empty");
			return null;
		}		
		else
			return minElm;
	}
}
public class StackwithGetMin 
{
	public static void main(String[] args) 
	{
		MyStack ms = new MyStack();
		ms.push(3);
		ms.push(5);
		System.out.println("Min Element "+ms.getMin());
		ms.push(2);
		System.out.println("Min Elemnet "+ms.getMin());
		ms.push(1);
		ms.push(1);
		ms.push(-1);
		System.out.println("Peek element "+ms.peek());
		System.out.println("Pooped : "+ms.pop());
		System.out.println("Min Elemnet "+ms.getMin());
		System.out.println("Pooped : "+ms.pop());
		System.out.println("Min Elemnet "+ms.getMin());
		System.out.println("Peek element "+ms.peek());
		System.out.println("Pooped : "+ms.pop());
		System.out.println("Min Elemnet "+ms.getMin());
		System.out.println("Pooped : "+ms.pop());
		System.out.println("Min Elemnet "+ms.getMin());
		System.out.println("Pooped : "+ms.pop());
		System.out.println("Min Elemnet "+ms.getMin());
		System.out.println("Pooped : "+ms.pop());
		System.out.println("Min Elemnet "+ms.getMin());
	}
}
