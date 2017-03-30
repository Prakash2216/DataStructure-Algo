package com.ds.algo.bst;

import java.util.Stack;

import com.ds.algo.tree.Node;

public class OneNodeIsMisplacedRecreateBST {
	// Prev is used to store the prev node to the root in inorder traversal
	Node prev=null;
	
	//Stack is used to store the sequence of prev node to recreate the BST
	Stack<Node> stk = new Stack<>();
	
	private boolean isBST(Node root){
		if(root != null){
			if(!isBST(root.left))
				return false;
			if(prev != null && prev.data > root.data){
				makeBST(root);
				return false;
			}
			prev = root;
			stk.push(prev);
			return isBST(root.right);
		}
		return true;
	}
	
	//API for recreating the BST
	private void makeBST(Node root){
		int temp;
		Node prev = null;
		while(!stk.isEmpty()){
			prev = stk.pop();
			if(prev.data > root.data){
				temp = root.data;
				root.data = prev.data;
				prev.data = temp;
				root = prev;
			}
		}
	}
	
	private void inOrderIterative(Node root){
		if(root == null)
			return;
		
		Node current = root;
		Stack<Node> s = new Stack<>();
		boolean flag = false;
		
		while(!flag){
			if(current != null){
				s.push(current);
				current = current.left;
			}
			else{
				if(!s.isEmpty()){
					current = s.pop();
					System.out.print(current.data+" ");
					current = current.right;
				}
				else
					flag = true;
			}
		}
	}
	public static void main(String[] args) {
		Node root = new Node(3);
		root.left = new Node(2);
		root.left.left = new Node(1);
		root.left.right = new Node(4);
		root.right = new Node(5);

		OneNodeIsMisplacedRecreateBST obj = new OneNodeIsMisplacedRecreateBST();
		System.out.println("is BST ? : "+ obj.isBST(root) );
		
		System.out.println("Recreating the BST...");
		obj.inOrderIterative(root);
	}

}
