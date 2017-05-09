package com.ds.algo.interview.amzn.set332;

import java.util.HashMap;

import com.ds.algo.tree.Node;
/**
 * WAP to print the Top View of Binary tree. 
 * 
 * Approach: There could be multiple approach to print the Top view of the BT.
 * 	1. Using Level order traversal and using horizontal distance.
 * 
 *  2. We implement the postorder traversal using horizontal distance.
 * @author Panna
 *
 */
public class PrintTopViewOfBT {

	public static void topView(Node root) {
		if(root == null)
			return;
		
		int hd =0;
		HashMap<Integer, Integer> map = new HashMap<>();
		
		topViewUtil(root, map, hd);
		
		if(map != null)
			System.out.println(map.entrySet());
	}
	private static void topViewUtil(Node root, HashMap<Integer, Integer> map, int hd) {
		if(root == null)
			return;
		
		topViewUtil(root.left, map, hd-1);
		topViewUtil(root.right, map, hd+1);
		
		if(map.get(hd) == null)
			map.put(hd, root.data);
	}
	
	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.left.right.left = new Node(10);
		root.left.right.left.left = new Node(11);
		root.right.left = new Node(6);
		root.right.left.right = new Node(7);
		root.right.left.right.right = new Node(8);
		
		topView(root);
	}

}
