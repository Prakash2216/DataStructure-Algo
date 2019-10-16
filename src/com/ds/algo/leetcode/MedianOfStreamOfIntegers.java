package com.ds.algo.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/*
 * Find the median of the given stream of integers.
 * Given that integers are read from a data stream. Find median of elements read so for in efficient way. For simplicity assume there are no duplicates. For example, let us consider the stream 5, 15, 1, 3 …
 * After reading 1st element of stream - 5 -> median - 5
 * After reading 2nd element of stream - 5, 15 -> median - 10
 * After reading 3rd element of stream - 5, 15, 1 -> median - 5
 * After reading 4th element of stream - 5, 15, 1, 3 -> median - 4, so on...
 * 
 * Solution: 
 * 
 */
public class MedianOfStreamOfIntegers 
{
	List<Integer> minHeap;
	List<Integer> maxHeap;
	int median = -1;
	public MedianOfStreamOfIntegers()
	{
		minHeap = new ArrayList<>();
		maxHeap = new ArrayList<>();
	}
	
	public void maxHeapify(int i, int size)
	{
		int largest = i;
		int l = 2*i+1;
		int r = 2*i+2;
		
		if(l < size && maxHeap.get(l) > maxHeap.get(largest))
			largest = l;
		if(r < size && maxHeap.get(r) > maxHeap.get(largest))
			largest = r;
		
		if(largest != i)
		{
			int tempL = maxHeap.get(largest);
			int tempI = maxHeap.get(i);
			maxHeap.remove(largest);
			maxHeap.add(largest, tempI);
			maxHeap.remove(i);
			maxHeap.add(i, tempL);
			
			maxHeapify(largest, size);
		}
	}
	
	public void minHeapify(int i, int size)
	{
		int smallest = i;
		int l = 2*i+1;
		int r = 2*i+2;
		
		if(l < size && minHeap.get(l) < minHeap.get(smallest))
			smallest = l;
		if(r < size && minHeap.get(r) < minHeap.get(smallest))
			smallest = r;
		
		if(smallest != i)
		{
			int tempS = minHeap.get(smallest);
			int tempI = minHeap.get(i);
			minHeap.remove(smallest);
			minHeap.add(smallest, tempI);
			minHeap.remove(i);
			minHeap.add(i, tempS);
			
			minHeapify(smallest, size);
		}		
	}
	
	public void insertMaxHeap(int e)
	{
		maxHeap.add(0, e);
		
		maxHeapify(0, maxHeap.size());
	}
	
	public void insertMinHeap(int e)
	{
		minHeap.add(0, e);
		
		minHeapify(0, minHeap.size());
	}
	
	public int getMaxTop()
	{
		return maxHeap.get(0);
	}
	
	public int getMinTop()
	{
		return minHeap.get(0);
	}
	
	public int extractMinTop()
	{
		int top = minHeap.remove(0);
		
		minHeapify(0, minHeap.size());
		
		return top;
	}
	public int extractMaxTop()
	{
		int top = maxHeap.remove(0);
		
		maxHeapify(0, maxHeap.size());
		
		return top;
	}
	
	public int findMedian(int s)
	{		
		int diff = maxHeap.size()-minHeap.size();
		
		
		if( diff == 0)
		{
			if(s <= median)
			{
				insertMaxHeap(s);
				median = getMaxTop();
			}
			else
			{
				insertMinHeap(s);
				median =getMinTop();
			}
		}
		else if(diff == -1)
		{
			if(s <= median)
			{
				insertMaxHeap(s);
			}
			else
			{
				insertMaxHeap(extractMinTop());
				insertMinHeap(s);
			}
			median = (getMaxTop()+getMinTop())/2;
		}
		else
		{
			if(s <= median)
			{
				insertMinHeap(extractMaxTop());
				insertMaxHeap(s);
			}
			else
			{
				insertMinHeap(s);
			}
			median = (getMaxTop()+getMinTop())/2;
		}
		
		return median;		
	}
	
	public static void main(String[] args) 
	{
			
		MedianOfStreamOfIntegers obj = new MedianOfStreamOfIntegers();
		
		int A[] = {5, 15, 1, 3, 2, 8, 7, 9, 10, 6, 11, 4};
		
		for(int i = 0; i< A.length; i++)
		{
			
			System.out.println(obj.findMedian(A[i]));
		}
	}

}
