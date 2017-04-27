package com.ds.algo.graph;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {
	int v;
	LinkedList<Integer> adj[]; // Adjacency List for creating the graph.
	
	public BFS(int v){
		this.v =v;
		adj = new LinkedList[v];
		
		for(int i=0; i<v; i++){
			adj[i] = new LinkedList<>();
		}
	}
	// adding edge between two vertices v, u.
	public void addEdge(int v, int u){
		adj[v].add(u);
	}
	
	public void breadthFirstSearch(int s){
		
		// visited is used to track the cycle in graph.
		boolean visited[] = new boolean[v];
		Queue<Integer> queue = new LinkedList<>();
		queue.add(s);
		
		while(!queue.isEmpty()){
			s = queue.poll();
			System.out.print(s+" ");
			
			Iterator<Integer> it = adj[s].iterator();
			while(it.hasNext()){
				int n = it.next();
				
				if(!visited[n]){
					visited[n]=true;
					queue.add(n);
				}
			}
		}
	}
	public static void main(String[] args) {
		BFS graph = new BFS(4);
		graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);
 
        System.out.println("Following is Breadth First Traversal "+
                           "(starting from vertex 2)");
 
        graph.breadthFirstSearch(2);
	}

}
