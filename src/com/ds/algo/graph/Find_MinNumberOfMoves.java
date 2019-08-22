package com.ds.algo.graph;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/** 
 * Find the minimum number of moves to move from one cell of Matrix to another.
 * Given a N X N matrix (M) filled with 1 , 0 , 2 , 3 . Find the minimum numbers of moves needed to move from source to destination (sink).
 * while traversing through blank cells only. You can traverse up, down, right and left.
 * A value of cell 1 means Source.
 * A value of cell 2 means Destination.
 * A value of cell 3 means Blank cell.
 * A value of cell 0 means Blank Wall.
 * 
 * Approach:: first create a graph of each cell as node and boundary between cell as edge and to BFS. 
 */
 
//class graph for creating graph using adjacency list.
class Graph{
	int V;
	LinkedList<Integer> []adj;
	
	public Graph(int V){
		this.V = V;
		adj = new LinkedList[V];
		for(int i=0; i<V; i++)
			adj[i] = new LinkedList<>();
	}
	
	// Since graph is not directed.
	public void addEdge(int u, int w){
		if(!adj[u].contains(w)) {
			adj[u].add(w);
			adj[w].add(u);
		}
	}
	
	public int BSFMin(int s, int d){
		
		if(s == d)
			return 0;
		
		int []level = new int[V];
		for(int i=0; i<V; i++)
			level[i] = -1;
		
		Queue<Integer> queue = new LinkedList<>();
		queue.add(s);
		level[s]=0;
		
		while(!queue.isEmpty()) {
			s = queue.poll();
			
			Iterator<Integer> it = adj[s].iterator();
			while(it.hasNext()) {
				int t = it.next();
				if(level[t] < 0 || level[t] > level[s]+1) {
					level[t] = level[s]+1;
					queue.add(t);
				}
			}
		}
		
		return level[d];
	}
}

public class Find_MinNumberOfMoves {
	
	private boolean isSafe(int i, int j, int n, int[][]M) {
		
		if(i<0 || i>=n || j<0 || j>=n || M[i][j] == 0)
			return false;
		return true;
	}
	private int minPath(int[][] M, int n) {
				int V = n*n+2;
				//source and destination vertex
				Graph g = new Graph(V);
				int s=0, d=0;
				int k=1;
				for(int i=0; i<n; i++){
					for(int j=0; j<n; j++){
						
						if(M[i][j] != 0){
							
							if(isSafe(i, j+1, n, M))
								g.addEdge(k, k+1);
							if(isSafe(i, j-1, n, M))
								g.addEdge(k, k-1);
							if(j<n-1 && isSafe(i+1, j, n, M))
								g.addEdge(k, k+n);
							if(i>0 && isSafe(i-1, j, n, M))
								g.addEdge(k, k-n);
						}
						
						//Assigning Source and Destination vertex.
						if(M[i][j] == 1)
							s=k;
						if(M[i][j] == 2)
							d=k;
						k++;
					}
				}
				return g.BSFMin(s, d);
	}
	
	public static void main(String[] args) {
		
		int M[][] = {{ 3 , 3 , 1 , 0 },
		        	 { 3 , 0 , 3 , 3 },
		        	 { 2 , 3 , 0 , 3 },
		        	 { 0 , 3 , 3 , 3 }};
		
		int n = M.length;
		Find_MinNumberOfMoves obj = new Find_MinNumberOfMoves();
		System.out.println(obj.minPath(M, n));
	}

}
