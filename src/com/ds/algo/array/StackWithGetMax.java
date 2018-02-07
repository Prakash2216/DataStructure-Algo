package com.ds.algo.array;

import java.util.Stack;

class MaxStack
{
	int maxElm;
	Stack<Integer> s=null;
	
	public MaxStack()
	{
		s = new Stack<>();
	}
	
	public void push(int x)
	{
		if(s.isEmpty())
		{
			maxElm = x;
			s.push(x);
			System.out.println("Inserted : "+x);
			return;
		}
		
		if(x > maxElm)
		{
			s.push(2*x+maxElm);
			maxElm = x;			
		}
		else
			s.push(x);
		System.out.println("Inserted : "+x);
	}
	public Integer pop()
	{
		if(s.isEmpty())
		{
			System.out.println("Stack is Empty");
			return null;
		}
		
		Integer y = s.pop();
		if(y > maxElm)
		{
			int temp = maxElm;
			maxElm = (y - 2*maxElm);
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
		if(y > maxElm)
			return maxElm;
		else
			return y;
	}
	
	public Integer getMax()
	{
		if(s.isEmpty())
		{
			System.out.println("Stack is Empty");
			return null;
		}
		else
			return maxElm;
	}
}
public class StackWithGetMax 
{
	public static void main(String[] args) 
	{
		MaxStack ms = new MaxStack();
		ms.push(5);
		ms.push(3);
		ms.push(2);
		ms.push(6);
		System.out.println("Max element : "+ms.getMax());
		System.out.println("Peek : "+ms.peek());
		ms.push(7);
		ms.push(10);
		//System.out.println("Max element : "+ms.getMax());
		System.out.println("Popped : "+ms.pop());
		//System.out.println("Max element : "+ms.getMax());
		System.out.println("Popped : "+ms.pop());
		//System.out.println("Max element : "+ms.getMax());
		System.out.println("Popped : "+ms.pop());
		//System.out.println("Peek : "+ms.peek());
		//System.out.println("Max element : "+ms.getMax());
		System.out.println("Popped : "+ms.pop());
		//System.out.println("Max element : "+ms.getMax());
		System.out.println("Popped : "+ms.pop());
		System.out.println("Popped : "+ms.pop());
	}

}
