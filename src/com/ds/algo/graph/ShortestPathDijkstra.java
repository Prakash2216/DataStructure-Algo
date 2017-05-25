package com.ds.algo.graph;

public class ShortestPathDijkstra {

	static int V=4;
	private void dijkstra(int[][] graph, int src) {
		//dist is output array containing the shortest distance from src to i.
		int []dist = new int[V];
		
		//sptSet is true if the vertex is included in shortest path tree or included in shortest distance from src to i.
		boolean []sptSet = new boolean[V];
		
		for(int i=0; i<V; i++) {
			dist[i] = Integer.MAX_VALUE;
			sptSet[i] = false;
		}
		
		dist[src]=0;
		
		for(int count=0; count<V-1; count++) {
			//find the min dist vertex from the set of vertices not yet processed. 
			int u = minDist(dist, sptSet);
			sptSet[u]=true;
			
			//update the distance of adjacent vertex of u picked vertex.
			for(int v=0; v<V; v++) {
				//update dist[v] if v is not is sptSet. if there is an edge from u to v. the total weight of path from src to v
				// through u is smaller than dist[v].
				if(!sptSet[v] && graph[u][v] != 0 && dist[u] != Integer.MAX_VALUE && dist[u]+graph[u][v] < dist[v])
					dist[v] = dist[u]+graph[u][v];
			}			
		}
		printDist(dist);
	}
	private void printDist(int[] dist) {
		
		System.out.println("Vertex Distance from source");
		for(int v=0; v<V; v++) {
			System.out.println(v+" "+dist[v]);
		}
	}
	private int minDist(int[] dist, boolean[] sptSet) {
		int min = Integer.MAX_VALUE;
		int minIndex=-1;
		for(int i=0; i<V; i++) {
			if(!sptSet[i] && dist[i]<min) {
				min=dist[i];
				minIndex = i;
			}				
		}
		return minIndex;
	}
	public static void main(String[] args) {
		int [][]graph = {{0,10,20,0},
						 {10,0,5,16},
						 {20,5,0,20},
						 {0,16,20,0}};
		
		ShortestPathDijkstra obj = new ShortestPathDijkstra();
				obj.dijkstra(graph, 0);
	}
}
