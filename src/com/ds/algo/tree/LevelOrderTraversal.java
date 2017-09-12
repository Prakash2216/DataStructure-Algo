package com.ds.algo.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * The Level Order Traversal(BFS). We print the nodes in lever order of the given tree.
 * 
 * There are two approaches 
 * 
 * Approach 1: Recursive approach which has the Time complexity as O(n^2).
 * 
 * Approach 2: In this approach we use the external queue for storing the nodes level wise O(n).
 * 
 * Approach 3: Print nodes line wise per level in level order traversal using the approach2 O(n).
 * 
 * @author 1019270
 *
 */

public class LevelOrderTraversal {
	
	//Approach 1: Recursive 
	void printLevelOrder(Node root){
		if(root == null){
			System.out.println("Tree is null");
			return;
		}
		int h = getHeight(root);
		
		for(int i=0; i<h; i++){
			printGivenLevel(root, i);
		}
	}
	
	void printGivenLevel(Node root, int i) {
		
		if(root == null)
			return;
		if(i==0)
			System.out.print(root.data+" ");
		printGivenLevel(root.left, i-1);
		printGivenLevel(root.right, i-1);
	}

	int getHeight(Node root){
		if(root == null)
			return 0;
		
		int lh = getHeight(root.left);
		int rh = getHeight(root.right);
		
		return lh>rh ? lh+1 : rh+1;
	}
	
	
	//Approach 2: Using External queue
	
	void printLevelOrderEQ(Node root){
		
		if(root == null){
			System.out.println("Tree is Null");
			return;
		}
		
		Queue<Node> q = new LinkedList<>();
		q.add(root);
		
		while(!q.isEmpty()){
			Node temp = q.poll();
			System.out.print(temp.data+" ");
			
			if(temp.left != null)
				q.add(temp.left);
			if(temp.right != null)
				q.add(temp.right);
		}
 	}
	
	//Approach 3: Level wise print in line
	void printLevelPerLine(Node root){
		
		if(root == null){
			System.out.println("Tree is Null");
			return;
		}
		
		Queue<Node> qe = new LinkedList<>();
		qe.add(root);
		
		while(!qe.isEmpty()){
			
			int countSize = qe.size();
			
			while(countSize > 0){
				Node temp = qe.poll();
				System.out.print(temp.data+" ");
				
				if(temp.left != null)
					qe.add(temp.left);
				if(temp.right != null)
					qe.add(temp.right);
				
				countSize--;
			}
			System.out.println(" ");
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
		
		LevelOrderTraversal obj = new LevelOrderTraversal();
		obj.printLevelOrder(root);
		System.out.println("done1\n\n");
		
		obj.printLevelOrderEQ(root);
		System.out.println("done2\n\n");
		
		obj.printLevelPerLine(root);
		System.out.println("done3");
	}

}
