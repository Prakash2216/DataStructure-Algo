package com.ds.algo.tree;

import java.util.Stack;

public class OneNodeIsMisplacedRecreateBST {
	
	//Prev pointer is used to point the previous node in inorder traversal
	public static Node prev=null;
	Stack<Node> store = new Stack();
	
	private boolean isBST(Node root){
		if(root != null){
			if(!isBST(root.left))
				return false;
			
			if(prev != null && prev.data > root.data){
				createBST(root);
				return false;
			}
			prev = root;
			store.push(prev);
			return isBST(root.right);				
		}
		return true;
	}
	
	private void createBST(Node root){
		int temp;
		Node prev=null;
		while(!store.isEmpty()){
			prev = store.pop();
			
			if(prev.data > root.data){
				temp = root.data;
				root.data = prev.data;
				prev.data = temp;
				root = prev;
			}
		}
	}
	
	//Iterative way of Printing the BST
	private void InorderTraversal(Node root){
		if(root == null)
			return;
		Node current = root;
		Stack<Node> stk = new Stack();
		boolean flag=false;
		
		while(!flag){
			if(current != null){
				stk.push(current);
				current = current.left;
			}
			else{
				if(!stk.isEmpty()){
					current = stk.pop();
					System.out.print(current.data+" ");
					current = current.right;
				}
				else
					flag=true;
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
		System.out.println("Inorder Traversal of BST before Recreating BST : \n");
		obj.InorderTraversal(root);
		
		System.out.println("\n\nisBST ? "+obj.isBST(root));
		System.out.println("\nInorder Traversal Of BST After checking isBST :\n");
		obj.InorderTraversal(root);

	}

}
