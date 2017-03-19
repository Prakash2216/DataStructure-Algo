package com.ds.algo.tree;
/**
 * WAP to print the Post order Traversal of Binary Tree Iteratively.
 * 
 */
import java.util.Stack;

public class PostorderIterative {

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
					System.out.print(temp.data+" ");
					while(!stk.isEmpty() && temp == stk.peek().right) {
						temp = stk.pop();
						System.out.print(temp.data+" ");
					}
				}
				else
					current = temp;
			}
		}
	}
	
	public void postRecursive(Node root) {
		if( root == null)
			return;
		
		postRecursive(root.left);
		postRecursive(root.right);
		System.out.print(root.data+" ");
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
		
		PostorderIterative obj = new PostorderIterative();
		System.out.println("PostOrder Traversal Recursive::\n");
		obj.postRecursive(root);
		System.out.println("\n\nPostOrder Traversal Iterative::\n");
		
		obj.postIterative(root);
	}

}
