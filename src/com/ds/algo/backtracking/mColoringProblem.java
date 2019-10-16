package com.ds.algo.backtracking;

/**
 * The graph coloring problem is the problem of coloring the graph vertices with the m colors in such a way that no two
 * adjacent vertices should have the same color.
 * 
 * Approach : We use the backtracking to color the graph. First we check the graph is assigned or not if not the assign 
 * that color to the vertices. if the color is already used to adjacent vertices then pass the next color.
 * 
 * @author Prakash2216
 *
 */
public class mColoringProblem 
{
	/**
	 * @param graph is representing the adjacency matrix.
	 * @param m is the no of colors.
	 * @param V is the no of vertices.
	 */
	public static void graphColoring(int [][]graph, int m, int V)
	{
		if(m == 0 || V == 0)
		{	
			System.out.println("No solution exist");
			return;
		}
		//it will have colors assigned to the vertices.
		int [] color = new int [V];
		
		if(!graphColoringUtil(graph, color, m, 0, V))
		{
			System.out.println("Solution Doesn't exits");
		}
		else
			printSolution(color);
	}
	private static void printSolution(int[] color) 
	{
		for(int c : color)
			System.out.print(c+" ");
	}
	private static boolean graphColoringUtil(int[][] graph, int[] color, int m, int v, int V) 
	{
		//All color are assigned to each vertices.
		if(v == V)
			return true;
		
		for(int c=1; c<=m; c++)
		{
			if(isSafe(graph, color, c, v, V))
			{
				color[v] = c;
				if(graphColoringUtil(graph, color, m, v+1, V))
					return true;
				color[v]=0; 
			}
		}
		return false;		
	}
	private static boolean isSafe(int[][] graph, int[] color, int c, int v, int V) 
	{
		for(int i=0; i<V; i++)
		{
			if(graph[v][i] == 1 && c == color[i])
				return false;
		}
		return true;
	}
	public static void main(String[] args) 
	{
		int [][] graph = {{0, 1, 1, 1},
						  {1, 0, 1, 0},
						  {1, 1, 0, 1},
						  {1, 0, 1, 0}};
		int V=4;
		int m = 3;
		graphColoring(graph, m, V);
	}

}
