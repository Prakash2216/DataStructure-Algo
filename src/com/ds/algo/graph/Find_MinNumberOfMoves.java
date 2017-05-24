package com.ds.algo.graph;

import java.util.LinkedList;

class Graph{
	int V;
	LinkedList<Integer> []adj;
	
	public Graph(int V){
		this.V = V;
		for(int i=0; i<V; i++)
			adj[i] = new LinkedList<>();
	}
	
	public void addEdge(int u, int w){
		adj[u].add(w);
		adj[w].add(u);
	}
	
	public int BSFMin(int s, int d){
		return 0;
	}
}

public class Find_MinNumberOfMoves {
	
	private void minPath(int[][] M, int n) {
				int V = n*n+2;
				//source and destination vertex
				Graph g = new Graph(V);
				int s, d;
				int k=1;
				for(int i=0; i<n; i++){
					for(int j=0; j<n; j++){
						
						if(M[i][j] != 0){
							
							if(isSafe(i, j+1, M)){
								g.addEdge(k, k+1);
							}
							if(isSafe(i+1, j, M))
								g.addEdge(k+1, k);
						}
						
						//Assigning Source and Destination vertex.
						if(M[i][j] == 1)
							s=k;
						if(M[i][j] == 2)
							d=k;
					}
				}
	}
	public static void main(String[] args) {
		
		int M[][] = {{ 3 , 3 , 1 , 0 },
		        	 { 3 , 0 , 3 , 3 },
		        	 { 2 , 3 , 0 , 3 },
		        	 { 0 , 3 , 3 , 3 }};
		
		int n = M.length;
		Find_MinNumberOfMoves obj = new Find_MinNumberOfMoves();
		obj.minPath(M, n);
	}

}
