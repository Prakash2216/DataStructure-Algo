package com.ds.algo.list;

public class ReverseAlternateKNodes 
{
	public static ListNode _reverseAlternateKNodes(ListNode head, int k)
	{
		if(head == null || k<=0)
			return head;
		
		ListNode curr = head;
		ListNode prev = null;
		ListNode next = null;
		int count = 0;
		
		while(curr != null && count<k)
		{
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
			count++;
		}
		
		if(head != null)
			head.next = curr;
		
		count=0;
		while(curr != null && count < k-1)
		{
			curr = curr.next;
			count++;
		}
		
		if(curr != null)
			curr.next =	_reverseAlternateKNodes(curr.next, k);
		
		return prev;
	}
	
	public static void print(ListNode head)
	{
		if(head == null)
			return;
		
		System.out.print(head.data+" ");
		print(head.next);
	}
	
	public static void main(String[] args) 
	{
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next = new ListNode(6);
		head.next.next.next.next.next.next = new ListNode(7);
		head.next.next.next.next.next.next.next = new ListNode(8);
		head.next.next.next.next.next.next.next.next = new ListNode(9);
		head.next.next.next.next.next.next.next.next.next = new ListNode(10);
		
		System.out.println("Print List before reverse alternate");
		print(head);
		
		ListNode tHead=_reverseAlternateKNodes(head, 3);
		
		System.out.println("\nPrint list after reverse alternate");
		print(tHead);
		
	}

}
