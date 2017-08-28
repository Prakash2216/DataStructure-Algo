package com.ds.algo.interview.amzn.set330;

import java.util.Stack;

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
			System.exit(0);
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
