package com.ds.algo.interview.amzn.set333;

import java.util.ArrayList;

/**
 * The cost of a stock on each day is given in an array, find the max profit that you can make by buying and selling in those days. 
 * For example, if the given array is {100, 180, 260, 310, 40, 535, 695}, the maximum profit can earned by buying on day 0,
 * selling on day 3. Again buy on day 4 and sell on day 6. 
 * If the given array of prices is sorted in decreasing order, then profit cannot be earned at all.
 * 
 * Approach: 
 * 
 * 1. Find the local minimum and maximum value and store their index as starting and ending index.
 * 2. repeat the step 1 till the array end.
 * 
 * @author Prakash Singh
 *
 */
class Interval{
	int buy;
	int sell;
}
public class StockBuyAndSellToMaximizeprofit {

	private void maxProfit(int [] stock, int n) {
		if(n==1)
			return;
		
		ArrayList<Interval> list = new ArrayList<>();
		int count=0;
		int i=0;
		while(i < n-1) {
			
			while((i < n-1) && (stock[i] >= stock[i+1]))
				i++;
			
			if(i == n-1)
				break;
			Interval e = new Interval();
			e.buy = i++;
			
			while((i < n) &&( stock[i-1] <= stock[i]) )
				i++;
			
			e.sell = i-1;
			list.add(e);
			
			count++;
		}
		
		if(count == 0)
			System.out.println("There is no stockes that can be buy or sell");
		else {
				for(int j=0; j<count; j++) {
					System.out.println("Buy on day "+list.get(j).buy +" sell on day "+list.get(j).sell);
				}
		}
	}
	public static void main(String[] args) {
		
		
		int [] stock = {100, 180, 260, 310, 40, 535, 695};
		StockBuyAndSellToMaximizeprofit obj = new StockBuyAndSellToMaximizeprofit();
		obj.maxProfit(stock, stock.length);
	}

}
