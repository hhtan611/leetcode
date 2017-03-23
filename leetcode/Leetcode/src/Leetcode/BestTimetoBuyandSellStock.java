package Leetcode;

/*
 Author:     King, higuige@gmail.com
 Date:       Oct 07, 2014
 Problem:    Best Time to Buy and Sell Stock
 Difficulty: Easy
 Source:     http://leetcode.com/onlinejudge#question_121
 Notes:
 Say you have an array for which the ith element is the price of a given stock on day i.
 If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), 
 design an algorithm to find the maximum profit.
 Solution: For each element, calculate the max difference with the former elements.
 */

public class BestTimetoBuyandSellStock {
	public static void main(String[] args) {
		int [] aa ={1,2,3,5,3};
		System.out.println(maxProfit1(aa));
	}
	public static int maxProfit1(int[] prices) {
		int len = prices.length;
		if (len <= 1)
			return 0;
		int diff = 0, d = 0;
		for (int i = 0; i < len; i++) {
			for (int j = i + 1; j < len; j++) {
				if (prices[i] < prices[j])
					d = prices[j] - prices[i];
				if (d > diff)
					diff = d;
			}
		}
		return diff;
	}

	public static int maxProfit(int[] prices) {
		int n = prices.length;
		if (n <= 1)
			return 0;
		int res = 0, minVal = prices[0];
		for (int i = 1; i < n; ++i) {
			res = Math.max(res, prices[i] - minVal);
			minVal = Math.min(minVal, prices[i]);
		}
		return res;
	}
}
