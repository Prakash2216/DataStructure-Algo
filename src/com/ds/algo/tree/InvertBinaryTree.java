package com.ds.algo.tree;

/**
 * You are given the root of a binary tree. Invert the binary tree in place. 
 * That is, all left children should become right children, and all right children should become left children.
 * 
 * 
 * @author Prakash2216
 *
 */

public class InvertBinaryTree 
{
	
	public static void invert(Node root)
	{
		if(root == null)
			return;
		
		Node temp = root.left;
		root.left = root.right;
		root.right = temp;
		
		invert(root.left);
		invert(root.right);
	}
	
	public static void print(Node root)
	{
		if(root == null)
			return;
		print(root.left);
		System.out.print(root.data+" ");
		print(root.right);
	}
	public static void main(String[] args) 
	{
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		
		System.out.println("Inorder before inversion\n");
		print(root);
		System.out.println("\n\nInorder after inversion\n");
		invert(root);
		print(root);
	}

}
