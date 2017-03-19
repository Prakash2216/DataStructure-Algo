package com.ds.algo.tree;
/** 
 * WAP to check the value of a node is equal to the sum of the value of left child and right child.
 * @author Prakash2216
 *
 */
public class ChildrenSumProperty {

	private boolean isChildSum(Node root) {
		int leftdata=0; int rightdata=0;
		
		if(root == null ||(root.left == null && root.right == null))
			return true;
		
		if(root.left != null)
			leftdata = root.left.data;
		
		if(root.right != null)
			rightdata = root.right.data;
		
		if(root.data == leftdata+rightdata && isChildSum(root.left) && isChildSum(root.right))
			return true;
		else
			return false;
	}
	public static void main(String[] args) {
		Node root = new Node(10);
		root.left = new Node(8);
		root.right = new Node(2);
		root.left.left = new Node(3);
		root.left.right = new Node(5);
		root.right.left = new Node(2);
		
		ChildrenSumProperty obj = new ChildrenSumProperty();
		System.out.println("Tree holds the children sum property ? :: "+obj.isChildSum(root));
				
	}

}
