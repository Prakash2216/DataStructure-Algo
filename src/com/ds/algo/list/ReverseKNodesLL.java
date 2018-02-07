package com.ds.algo.list;

public class ReverseKNodesLL {
		 
	private static ListNode reverseKNodes(ListNode head, int k) 
	{
		if(k<=0 || head == null)
			return head;
		
		ListNode curr = head;
		ListNode prev = null;
		ListNode next;
		int count =0;
		
		while(curr != null && count < k)
		{
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
			count++;
		}
		if(curr != null)
			head.next = reverseKNodes(curr, k);
		return prev;
	}

	public static void print(ListNode head)
	{
		if(head != null)
		{
			System.out.print(head.data+" ");
			print(head.next);
		}
	}
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next = new ListNode(4);
		head.next.next.next = new ListNode(5);
		head.next.next.next.next = new ListNode(6);
		head.next.next.next.next.next = new ListNode(7);
		
		System.out.println("Printing List before reversing");
		print(head);
		
		int k =3;
		ListNode node = reverseKNodes(head, k);
		System.out.println("\nPrinting List after reversing");
		print(node);
	}	
}
