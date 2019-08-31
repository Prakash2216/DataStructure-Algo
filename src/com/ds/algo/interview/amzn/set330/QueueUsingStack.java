package com.ds.algo.interview.amzn.set330;

import java.util.Stack;

/**
 * WAP to create a queue using the stack. 
 * 
 * Approach 1: We can create a queue using the 2 stack. In this also there are two different ways
 * 			1: In 1st way, we can first check whether stack1 is empty or not, if not empty we pop the element from the first
 * 			   Stack1 and push into stack2 until empty. Now new element push into stack1 so that new element is at the last of 
 * 			   queue. Now pop all element from stack2 and push in stack1.
 * 			   for dequeue we just pop the top element from top of stack1 and return.
 * 
 * 			2: In this 2nd way we can push all the element in the stack1 for enqueue operation. For dequeue we first pop all
 * 			   the elements from stack1 and push into stack2, the last element from stack1 is returned.
 * 
 * Approach 2: Using single stack, in this we don't use external 2nd stack, instead we use the call stack.
 * 			 : Here this approach is only implemented.
 * 
 * 
 * @author Prakash2216
 *
 */
class Queue{
	Stack<Integer>s;
	
	Queue(){
		s = new Stack<>();
	}
	
	public void enqueue(int data) {
		s.push(data);
	}
	
	public Integer dequeue() {
		int x, res=0;
		
		if(s.isEmpty()) {
			System.out.println("Queue is empty");
		}
		else if(s.size() == 1)
			return s.pop();
		else {
			x = s.pop();
			res = dequeue();
			s.push(x);
			return res;
		}			
		return 0;
	}
}
public class QueueUsingStack {

	public static void main(String[] args) {
		Queue q = new Queue();
		
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());

	}

}
