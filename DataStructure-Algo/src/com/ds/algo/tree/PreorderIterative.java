package com.ds.algo.tree;
/**
 * WAP for Printing the tree in preorder.
 */
import java.util.Stack;

import com.ds.algo.tree.Node;

public class PreorderIterative {

	public void preorder(Node root) {
		if(root == null)
			return;
		Node current=root;
		boolean flag = false;
		Stack<Node> stk = new Stack<>();
		
		while(!flag) {
			if(current != null) {
				System.out.print(current.data+" ");
				if(current.right != null)
					stk.push(current.right);
				current = current.left;
			}
			else {
				if(!stk.isEmpty()) {
					current = stk.pop();
				}
				else
					flag = true;
			}
		}
	}
	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		
		PreorderIterative obj = new PreorderIterative();
		obj.preorder(root);
	}

}
