package com.ds.algo.tree;

public class PrintRootToLeafPath {

	private void printRootToLeaf(Node root) {
		if(root == null)
			return;
		
		int [] path = new int[20];
		int pLen = 0;
		
		printPathRootToLeaf(root, path, pLen);
	}
	
	private void printPathRootToLeaf(Node root, int[] path, int pLen) {
		
		if(root == null)
			return;
		
		path[pLen]=root.data;
		pLen++;
		
		if(root.left == null && root.right == null)
			printPath(path, pLen);
		
		printPathRootToLeaf(root.left, path, pLen);
		printPathRootToLeaf(root.right, path, pLen);
	}

	private void printPath(int[] path, int pLen) {
		for(int i=0; i < pLen; i++)
			System.out.print(path[i]+" ");
		System.out.println();
	}

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.left.right.left = new Node(8);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		
		PrintRootToLeafPath obj = new PrintRootToLeafPath();
		obj.printRootToLeaf(root);
	}

}
