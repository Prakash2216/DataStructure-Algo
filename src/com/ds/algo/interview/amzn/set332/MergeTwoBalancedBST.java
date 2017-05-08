package com.ds.algo.interview.amzn.set332;

import com.ds.algo.tree.Node;
/**
 * You are given two balanced binary search trees e.g., AVL or Red Black Tree. 
 * Write a function that merges the two given balanced BSTs into a balanced binary search tree. 
 * Let there be m elements in first tree and n elements in the other tree. Your merge function should take O(m+n) time.
 * 
 * @author Prakash Singh. 
 *
 *
 *Approach: 
 *1. first create the sorted array of two balanced BST.
 *2. Merge them in sorted order
 *3. create the Balanced BST
 */
public class MergeTwoBalancedBST {

	static int k=0;
	public int count(Node root) {
		if(root == null)
			return 0;
		return count(root.left)+1+count(root.right);
	}
	
	public void inorder(Node root, int []arr1) {
		if(root == null)
			return;
		inorder(root.left, arr1);
		arr1[k++]= root.data;
		inorder(root.right, arr1);
		
	}
	
	public void merge(int arr[], int arr1[], int arr2[], int m, int n) {
		
		int p=0;
		int q=0; int r=0;
		while(p < m  && q<n) {
			if(arr1[p] < arr2[q]) {
				arr[r++]=arr1[p++];
			}
			else
				arr[r++]=arr2[q++];
		}
		
		while(q<n) {
				arr[r++] = arr2[q++];
			}
		while(p<m) {
				arr[r++]=arr1[p++];
			}
	}
	
	public Node mergeBalancedBST(Node root1, Node root2) {
		
		if(root1 == null && root2 != null)
			return root2;
		if(root2 == null && root1 != null)
			return root1;
		if(root1 == null && root2 == null)
			return null;
		
		int m = count(root1);
		int n = count(root2);
		
		int arr1[] = new int[m];
		int arr2[] = new int[n];
		
		int arr[] = new int[m+n];
		inorder(root1, arr1);
		k=0;
		inorder(root2, arr2);
		
		merge(arr, arr1, arr2, m, n);
		
		Node node = createBalancedBST(arr, 0, m+n-1);
		return node;
	}  
	
	private Node createBalancedBST(int[] arr, int start, int end) {
		
		if(start <= end) {
			int mid = (start+end)/2;
			
			Node root = new Node(arr[mid]);
			
			root.left = createBalancedBST(arr, start, mid-1);
			root.right = createBalancedBST(arr, mid+1, end);
			return root;
		}
		return null;
	}

	public void inorderPrint(Node root) {
		if(root == null)
			return;
		inorderPrint(root.left);
		System.out.print(root.data+" ");
		inorderPrint(root.right);
	}
	public static void main(String[] args) {
		
		Node root = new Node(8);
		root.left = new Node(4);
		root.right = new Node(11);
		root.left.left = new Node(3);
		root.left.right = new Node(5);
		root.right.left = new Node(9);
		root.right.right = new Node(15);
		
		Node root1 = new Node(20);
		root1.left = new Node(10);
		root1.right = new Node(25);
		root1.left.left = new Node(7);
		root1.left.right = new Node(14);
		
		MergeTwoBalancedBST obj = new MergeTwoBalancedBST();
		Node node =obj.mergeBalancedBST(root, root1);
		obj.inorderPrint(node);
	}

}
