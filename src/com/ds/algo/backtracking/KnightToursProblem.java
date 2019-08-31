package com.ds.algo.backtracking;

import java.util.Arrays;

/**
 * In Knight tour problem, knight start from the first box(0, 0) and move to another box using the rule of chess.
 * if knight completes the tour by visiting all the boxes it returns true.
 * 
 * 
 * @author Prakash2216
 *
 */
public class KnightToursProblem 
{
	static int N = 8;
	
	public static boolean isSafe(int [][] sol, int x, int y)
	{
		return (x >=0 && x <N && y >= 0 && y < N && sol[x][y] == -1);
	}
	
	public static void solveKT()
	{
		int [][] sol = new int[N][N];
		
		//Initializing the sol[][] borad to -1
		for(int i=0; i<N; i++)
			Arrays.fill(sol[i], -1);
		
		//Moves, Knight can take 8 possible moves from a box.
		int [] xmove = {2, 1, -1, -2, -2, -1, 1, 2};
		int [] ymove = {1, 2, 2, 1, -1, -2, -2, -1};
		
		//starting point.
		sol[0][0] = 0;
		if(!solveKTUtil(0, 0, 1, xmove, ymove, sol))
			System.out.println("No solution does exist");
		else
		{
			System.out.println("Printing the solution");
			printSolution(sol);
		}
	}

	private static boolean solveKTUtil(int x, int y, int moveI, int [] xmove, int [] ymove, int[][] sol) 
	{
		int next_x, next_y;
		
		// Base condition to end execution.
		if(moveI == N*N)
			return true;
		
		for(int k = 0; k < N; k++)
		{
			next_x = x+xmove[k];
			next_y = y+ymove[k];
			
			if(isSafe(sol, next_x, next_y))
			{
				sol[next_x][next_y] = moveI;
				if(solveKTUtil(next_x, next_y, moveI+1, xmove, ymove, sol))
					return true;
				else				
					sol[next_x][next_y] = -1; //Backtracking.
			}			
		}		
		return false;
	}
	
	private static void printSolution(int[][] sol) 
	{
		for(int i = 0; i<N; i++)
		{
			for(int j = 0; j<N; j++)
				System.out.print(sol[i][j]+"  ");
			System.out.println();
		}
	}

	public static void main(String[] args) 
	{
		solveKT();
	}

}
