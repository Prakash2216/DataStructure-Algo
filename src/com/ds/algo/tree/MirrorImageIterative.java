package com.ds.algo.tree;

import java.util.Stack;

public class MirrorImageIterative {

	private void postIterative(Node root) {
		Node current = root;
		Stack<Node>stk = new Stack<>();
		
		while(current != null || !stk.isEmpty()) {
			
			if(current != null) {
				stk.push(current);
				current = current.left;
			}
			else {
				Node temp = stk.peek().right;
				
				if(temp == null) {
					temp = stk.pop();
					Node aux = temp.left;
					temp.left = temp.right;
					temp.right = aux;
					//System.out.print(temp.data+" ");
					while(!stk.isEmpty() && temp == stk.peek().right) {
						temp = stk.pop();
						aux = temp.left;
						temp.left = temp.right;
						temp.right = aux;
						//System.out.print(temp.data+" ");
					}
				}
				else
					current = temp;
			}
		}
	}
	
	public void inorder(Node root) {
		if(root == null)
			return;
		inorder(root.left);
		System.out.print(root.data+" ");
		inorder(root.right);
	}
	
	public static void main(String[] args) {
		Node root = new Node(5);
		root.left = new Node(3);
		root.right = new Node(7);
		root.left.right = new Node(4);
		root.left.left = new Node(1);
		root.left.left.right = new Node(2);
		root.right.left = new Node(6);
		root.right.right = new Node(8);
		
		MirrorImageIterative obj = new MirrorImageIterative();
		
		System.out.println("Inorder Traversal Recursive before mirror image::\n");
		obj.inorder(root);
		obj.postIterative(root);
		System.out.println("\n\nPostOrder Traversal Iterative::\n");
		obj.inorder(root);
	}

}
