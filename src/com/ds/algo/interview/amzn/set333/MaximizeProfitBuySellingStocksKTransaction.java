package com.ds.algo.interview.amzn.set333;
/**
 * In share trading, a buyer buys shares and sells on future date. 
 * Given stock price of n days, the trader is allowed to make at most k transactions.
 * where new transaction can only start after previous transaction is complete.
 * find out maximum profit that a share trader could have made.
 * 
 * Approach: Solving this problem using Dynamic Programming.
 * @author Prakash Singh.
 *
 */
public class MaximizeProfitBuySellingStocksKTransaction {

	/**
	 * Slow Process it takes the O(k*n^2) time to compute the algorithm.
	 * 
	 * T[i][j] = Max(T[i][j-1], max(price[j]-price[m]+T[i-1][m]));
	 * where m=0,1,2....j-1.
	 * 
	 */
	public int maxProfit(int []prices, int k) {
		
		//Base condition
		if(prices.length ==0 || k == 0)
			return 0;
		int l = prices.length;
		int profit[][] = new int[k+1][l];
		
		System.out.println("Profit.length "+profit.length);
		for(int i=1; i<profit.length; i++) {
			for(int j=1; j<profit[0].length; j++) {
				int max=0;
				for(int m=0; m<j; m++) {
					max=Math.max(max, prices[j]-prices[m]+profit[i-1][m]);
				}
				profit[i][j] = Math.max(profit[i][j-1], max);
			}
		}
		return profit[k][l-1];
	}
	
	/**
	 * We can optimize the above solution to O(k*n) by making the following changes.
	 * 
	 * T[i][j] = Max(maxdif, prices[m]- T[i-1][m]+prices[j]);
	 * 
	 */
	public int optimizedMaxProfit(int [] prices, int k) {
		
		//Base condition
		if(prices.length == 0 || k == 0)
			return 0;
		
		int [][] profit = new int[k+1][prices.length];
		
		int maxDiff;
		
		for(int i=1; i<profit.length; i++) {
			maxDiff = -prices[0];
			for(int j=1; j<profit[0].length; j++) {
				profit[i][j] = Math.max(profit[i][j-1], prices[j]+maxDiff);
				maxDiff = Math.max(maxDiff, profit[i-1][j]-prices[j]);
			}			
		}
		return profit[k][prices.length-1];
	}
	public static void main(String[] args) {
		int prices[] = {2, 5, 7, 1, 4, 3, 1, 3};
		
		MaximizeProfitBuySellingStocksKTransaction obj = new MaximizeProfitBuySellingStocksKTransaction();
		System.out.println("Max profit :: "+obj.maxProfit(prices, 3));
		System.out.println("Max profit optimized :: "+obj.optimizedMaxProfit(prices, 3));
	}

}
