package com.ds.algo.tree;

import java.util.Stack;

import com.ds.algo.tree.Node;

/**
 * WAP to print the tree in inorder.
 * @author Panna
 *
 */
public class InorderIterative {

	public void inorder(Node root) {
		if(root == null)
			return;
		
		Node current = root;
		Stack<Node>stk = new Stack<>();
		boolean flag = false;
		
		while(!flag) {
			if(current != null) {
				stk.push(current);
				current = current.left;
			}
			else {
				if(!stk.isEmpty()) {
					current = stk.pop();
					System.out.print(current.data+" ");
					current = current.right;
				}
				else
					flag = true;
			}
		}
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
		
		InorderIterative obj = new InorderIterative();
		obj.inorder(root);
		
	}

}
