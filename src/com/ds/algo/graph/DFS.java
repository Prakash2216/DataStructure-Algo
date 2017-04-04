package com.ds.algo.graph;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Depth First Search is graph traversal where we start traversing the graph from the given root to the last child before traversing the adjacent child of the root.
 *  
 * @author 1019270
 *
 */
public class DFS {

	private int V; // No. of vertices in the graph.
	
	private LinkedList<Integer> adj[]; // Array of linkedList;
	
	public DFS(int v){
		this.V =v;
		adj = new LinkedList[V];
		for(int i=0; i<V; i++){
			adj[i] = new LinkedList<>();
		}
	}
	public void addEdge(int v, int w){
		adj[v].add(w);
	}
	public void depthFirstSearch(int v){
		boolean visited[] = new boolean[V];
		
		depthFirstSearchUtil(v, visited);
	}
	
	
	private void depthFirstSearchUtil(int v, boolean[] visited) {
		
		visited[v] = true;
		System.out.print(v+" ");
		Iterator<Integer> it = adj[v].iterator();
		
		while(it.hasNext()){
			int n = it.next();
			if(!visited[n])
			  depthFirstSearchUtil(n, visited);
		}
	}
	
	
	public static void main(String[] args) {
		DFS graph = new DFS(4);
		graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);
 
        System.out.println("Following is Depth First Traversal "+
                           "(starting from vertex 2)");
 
        graph.depthFirstSearch(2);
	}

}
