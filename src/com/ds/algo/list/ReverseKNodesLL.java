package com.ds.algo.list;

public class ReverseKNodesLL {
	
	//Iterative way of reversing 
	private static ListNode reverseKNodes(ListNode head, int k) 
	{
		if(k<=0)
			return head;
		
		ListNode curr = head;
		
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next = new ListNode(4);
		head.next.next.next = new ListNode(5);
		head.next.next.next.next = new ListNode(6);
		head.next.next.next.next.next = new ListNode(7);
		
		int k =3;
		ListNode node = reverseKNodes(head, k);
	}	
}
