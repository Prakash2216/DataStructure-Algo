package com.ds.algo.tree;

import java.util.Stack;

/**
 * WAP to find that given array is preorder traversal of BST.
 * Ex: Input pre[]={2, 4, 3}
 * 		output: true
 * 		
 * 	Input: pre[] ={40, 30, 35, 80, 100}
 * 	output: true
 * 
 * @author 1019270
 *
 */
public class GivenArrayPreorderTraversalOfBST {

	//Approach 1: find the first greater no. on right side of current node.
	//		1. return true if all the no. are greater than the above find greater value else return false;
	
	public boolean isPreorder(int []pre, int n){
		int current = pre[0];
		int gIndex=0;
		
		for(int i=1; i<n; i++){
			if(current < pre[i]){
				gIndex=i;
				break;
			}		
		}
		for(int j=gIndex+1; j<n; j++){
			if(current > pre[j])
				return false;
		}
		return true;
	}
	
	public boolean isRepresentPreorder(int []pre, int n){
		Stack stk = new Stack();
		int current = Integer.MIN_VALUE;
		
		for(int i=0; i<n; i++){
			if(current > pre[i])
				return false;
			
			while(!stk.isEmpty() && (int)stk.peek() < pre[i]){
				current = (int)stk.pop();
			}
			stk.push(pre[i]);
		}
		return true;
	}
	
	public static void main(String[] args) {
		int []pre = {2, 4, 3};
		//int [] pre = {2, 4, 1};
		GivenArrayPreorderTraversalOfBST obj = new GivenArrayPreorderTraversalOfBST();
		System.out.println("Given array is preorder of BST "+obj.isPreorder(pre, pre.length));
		
		System.out.println("Given array is preorder of BST 2 "+obj.isRepresentPreorder(pre, pre.length));

	}

}
