package com.ds.algo.interview.amzn.set330;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import com.ds.algo.tree.Node;

public class PrintTopViewofBinaryTree {

	private void printTopViewUtill(Node root, int hd, TreeMap<Integer, Integer> map) {
		if(root == null)
			return;
		
		printTopViewUtill(root.left, hd-1, map);
		printTopViewUtill(root.right, hd+1, map);
		
		map.put(hd, root.data);
	}
	private void printTopView(Node root) {
		if(root == null)
			return;
		int hd=0;
		TreeMap<Integer, Integer> map = new TreeMap<>();
		printTopViewUtill(root, 0, map);
		
		for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
			System.out.print(entry.getValue()+" ");
		}
	}
	
	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.right = new Node(4);
		root.left.right.right = new Node(5);
		root.left.right.right.right = new Node(6);
		
		PrintTopViewofBinaryTree obj = new PrintTopViewofBinaryTree();
		obj.printTopView(root);
	}

}
