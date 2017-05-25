package com.ds.algo.graph;

public class DFSUsingMatrix {
	int v=4;
	int [][] graph = {{0,1,1,0},
			  {0,0,1,1},
			  {1,0,0,1},
			  {0,0,0,1}};
	
		
	public void DFS(int s){
		boolean [] visited = new boolean[v];
		 
		DFSUtil(s,visited);
	}
	
	private void DFSUtil(int s, boolean[] visited) {
		System.out.print(s+" ");
		visited[s]=true;
		
		for(int j=0; j<v; j++){
			if(!visited[j] && graph[s][j]==1){
				DFSUtil(j, visited);
			}
		}
	}

	public static void main(String[] args) {
		
		DFSUsingMatrix obj = new DFSUsingMatrix();
		// 2 is source vertex of graph
		obj.DFS(2);
	}

}
