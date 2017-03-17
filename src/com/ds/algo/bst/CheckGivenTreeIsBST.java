package com.ds.algo.bst;
/**
 * We have given a binary tree, we to find the given binary tree is BST of Not.
 * 
 * Solution: This problem can we solve using multiple approach.
 * 
 *Approach 1: Simple:: Do a inorder traversal and save in an array. now scan the array if its sorted then given tree is BST else not.
 *
 * Approach 2. We can pass min and max value and check the root value with min and max if move to left then left node value should be less or equal to max-1 and vice versa.
 * 
 * Approach 3: By using the Static global variable of prev node.
 * 
 * Note: Implementing the app 1 and 2.
 * @author 1019270
 *
 */

import com.ds.algo.tree.Node;

public class CheckGivenTreeIsBST {

	public void checkBST(Node root){
		System.out.println("Given Binary Tree is BST using App 1 : "+isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
		
		System.out.println("\n");
		System.out.println("Given Binary Tree is BST using App 2 : "+isBST2(root));
	}
	// Approach 1
	public boolean isBST(Node root, int min, int max){
		
		if(root == null)
			return true;
		if(root.data > max || root.data < min)
			return false;
		
		return isBST(root.left, min, root.data-1) && isBST(root.right, root.data+1, max);
			
	}
	
	// Approach 2, Its a bottom Up approch
	// Global static variable Prev.
	static Node prev =null;
	public boolean isBST2(Node root){
		
		if(root != null){
			
			if(!isBST2(root.left))
				return false;
			
			if(prev != null && prev.data > root.data)
				return false;
			prev = root;
			
			return isBST2(root.right);
			
		}
		return true;
	}
	public static void main(String[] args) {
		
		Node root = new Node(3);
		root.left = new Node(2);
		root.right = new Node(5);
		root.left.left = new Node(1);
		root.left.right = new Node(4);
		
		CheckGivenTreeIsBST obj = new CheckGivenTreeIsBST();
		obj.checkBST(root);
	}

}
