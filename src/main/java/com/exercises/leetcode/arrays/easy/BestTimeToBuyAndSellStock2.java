package com.exercises.leetcode.arrays.easy;

@SuppressWarnings("unused")
public class BestTimeToBuyAndSellStock2 {
    public int maxProfit(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }

        int buy = -1;
        int sell = -1;
        int profit = 0;

        for (int i = 0; i < prices.length; i++) {
            if (buy == -1 || prices[i] <= buy) {
                buy = prices[i];
                continue;
            }
            if (sell == -1 || prices[i] > sell) {
                sell = prices[i];
                if (i != prices.length - 1 && sell < prices[i + 1]) {
                    continue;
                }
            }
            if (sell > buy && sell != -1 && buy != -1) {
                profit = profit + (sell - buy);
                sell = -1;
                buy = -1;
            }
        }
        return profit;
    }
}
