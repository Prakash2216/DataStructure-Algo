package com.ds.algo.tree;
/**
 * Given a binary tree, print boundary nodes of the binary tree AntiClockwise starting from the root.
 * 
 * @author Prakash2216
 * 
 * Approach: In this Approach divide the problem in three parts.
 * 	1.	First print the left nodes in top down manner.
 *  2.	Print the leaves from left to right.
 *  3. 	Print the right nodes in bottom up manner. 
 * 	
 *
 */
public class BoundryTraversalOfBT {
	
	private void printLeftBoundry(Node root) {
		if(root == null)
			return;
		
		if(root.left != null) {
			System.out.print(root.data+" ");
			printLeftBoundry(root.left);
		}
		else if(root.right != null) {
			System.out.print(root.data+" ");
			printLeftBoundry(root.right);
		}
	}
	
	private void printLeaves(Node root) {
		
		if(root == null)
			return;
		
		if(root.left == null && root.right == null)
			System.out.print(root.data+" ");
		printLeaves(root.left);
		printLeaves(root.right);
	}
	
	private void printRightBoundry(Node root) {
		
		if(root == null)
			return;
		
		if(root.right != null) {
			printRightBoundry(root.right);
			System.out.print(root.data+" ");
		}
		else if(root.left != null) {
			printRightBoundry(root.left);
			System.out.print(root.data+" ");
		}
	}
	private void printBoundry(Node root) {
		if(root == null)
			return;
		System.out.print(root.data+" ");
		printLeftBoundry(root.left);
		printLeaves(root);
		printRightBoundry(root.right);
	}
	public static void main(String[] args) {
		Node root = new Node(20);
		root.left = new Node(8);
		root.left.left = new Node(4);
		root.left.right = new Node(12);
		root.left.right.left = new Node(10);
		root.left.right.right = new Node(14);
		root.right = new Node(22);
		root.right.right = new Node(25);
		
		BoundryTraversalOfBT obj = new BoundryTraversalOfBT();
		obj.printBoundry(root);
	}
}
