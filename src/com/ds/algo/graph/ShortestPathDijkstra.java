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
