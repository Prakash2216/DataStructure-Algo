package com.ds.algo.tree;
/**
 * WAP to print all the nodes that are at k distance from the given node in the tree.
 * 
 * @author Prakash Singh
 *
 */
public class PrintAllNodesAtDistanceKtoGivenNode {

	private void printNodeAtKdistance(Node root, int node, int k){
		if(root == null)
			return;
		printNodeAtKdistUtil(root, node, k);
	}
	private int printNodeAtKdistUtil(Node root, int target, int k) {
		
		if(root == null)
			return -1;
		
		if(root.data == target){
			printKDistDown(root, k);
			return 0;
		}
		
		int dl = printNodeAtKdistUtil(root.left, target, k);
		
		if(dl != -1){
			
			if(dl+1 == k)
				System.out.print(root.data+" ");
			else{
				printKDistDown(root.right, k-dl-2);
				return dl+1;
			}
		}
		
		int dr = printNodeAtKdistUtil(root.right, target, k);
		
		if(dr != -1){
			
			if(dr+1 == k)
				System.out.print(root.data+" ");
			else{
				printKDistDown(root.left, k-dr-2);
				
				return dr+1;
			}
		}
		return -1;
	}
	private void printKDistDown(Node root, int k) {
		if(root == null || k<0)
			return;
		
		if(k == 0)
			System.out.print(root.data+" ");
		
		printKDistDown(root.left, k-1);
		printKDistDown(root.right, k-1);
		
	}
	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.left.right.left = new Node(6);
		root.left.right.right = new Node(7);
		root.left.right.left.left = new Node(8);
		root.left.right.left.right = new Node(9);
		root.left.right.right.right = new Node(10);
		root.left.left.left = new Node(11);
		root.right.right = new Node(12);
		
		// print all node at distance k from node.
		int k = 2;
		int node =5;
		PrintAllNodesAtDistanceKtoGivenNode obj = new PrintAllNodesAtDistanceKtoGivenNode();
		obj.printNodeAtKdistance(root, node, k);
	}

}
