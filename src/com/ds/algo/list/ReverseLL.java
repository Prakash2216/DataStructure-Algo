package com.ds.algo.list;

public class ReverseLL {
	private static ListNode reverseRec(ListNode head){
		if(head == null || head.next == null)
			return head;
		
		ListNode node = reverseRec(head.next);
		
		ListNode temp = head.next;
		temp.next = head;
		head.next = null;
		return node;
	}
	
	private static void print(ListNode head){
		if(head == null)
			return;
		System.out.print(head.data+" ");
		print(head.next);
	}
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		
		ListNode ptr = reverseRec(head);
	}

}
