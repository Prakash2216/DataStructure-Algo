package com.ds.algo.interview.amzn.set330;

import java.util.HashMap;

class DLL{
	int pageNum;
	DLL prev, next;
	public DLL(int pageNum){
		this.pageNum=pageNum;
		prev=null;
		next=null;
	}
}

class Cache{
	int cacheSize;
	int count;
	DLL head, tail;
	public Cache(int cacheSize){
		this.cacheSize = cacheSize;
		count=0;
		head = null;
		tail=null;
	}
	
	public boolean AllFramesFull(){
		if(this.count == this.cacheSize)
			return true;
		return false;
	}
	
}
public class LRU {

	public void enqueue(Cache cache, HashMap<Integer, DLL>map, int pageNum){
		
		if(cache.count == 0){
			DLL newNode = new DLL(pageNum);
			cache.head = cache.tail = newNode;
			map.put(pageNum, cache.head);
			cache.count++;
		}
			
		else if(cache.AllFramesFull())
		{
			int tempPage = cache.tail.pageNum;
			cache.tail = cache.tail.prev;
			cache.tail.next.prev = null;
			cache.tail.next=null;
			map.remove(tempPage);		
			
			DLL newNode = new DLL(pageNum);
			newNode.next = cache.head;
			cache.head.prev = newNode;
			cache.head = newNode;
			map.put(pageNum, cache.head);
			//cache.count++;
		}
		else
		{
			DLL newNode = new DLL(pageNum);
			newNode.next = cache.head;
			cache.head.prev = newNode;
			cache.head = newNode;
			map.put(pageNum, cache.head);
			cache.count++;

		}
	}
	public void referencePage(Cache cache, HashMap<Integer, DLL>map, int pageNum){
		
		DLL reqPage = map.get(pageNum);
		if(reqPage == null){
			enqueue(cache, map, pageNum);
		}
		else if( reqPage == cache.head){
			return;
		}
		else if(reqPage == cache.tail){
			cache.tail.prev.next = cache.tail.next;
			cache.tail.next = cache.head;
			cache.head.prev = cache.tail;
			cache.tail = cache.tail.prev;
			cache.head = cache.head.prev;
			cache.head.prev = null;
		}
		else{
			reqPage.prev.next = reqPage.next;
			reqPage.next.prev = reqPage.prev;
			cache.head.prev = reqPage;
			reqPage.next = cache.head;
			cache.head = reqPage;
			cache.head.prev = null;
		}
	}
	public static void main(String[] args) {
		
		HashMap<Integer, DLL>map = new HashMap<>();
		Cache cache = new Cache(4); // creating a cache of size 4.
		
		LRU lru = new LRU();
		//Let us refer pages 1, 2, 3, 1, 4, 5
		lru.referencePage(cache, map, 1);
		lru.referencePage(cache, map, 2);
		lru.referencePage(cache, map, 3);
		lru.referencePage(cache, map, 1);
		/*lru.referencePage(cache, map, 4);
		lru.referencePage(cache, map, 5);
		lru.referencePage(cache, map, 4);
		lru.referencePage(cache, map, 6);*/
		
		DLL ptr = cache.head;
		
		while(ptr != null)
		{
			System.out.print(ptr.pageNum +" ");
			ptr = ptr.next;
		}
		
	}

}
