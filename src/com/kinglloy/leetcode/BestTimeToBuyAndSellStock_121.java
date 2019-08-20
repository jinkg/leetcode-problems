package com.kinglloy.leetcode;

public class BestTimeToBuyAndSellStock_121 {
    public static void main(String[] args) {
        int[] prices = new int[]{7, 1, 5, 3, 6, 4};
        System.out.println(new BestTimeToBuyAndSellStock_121().maxProfit(prices));
    }

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int minDay = prices[0], maxDay = prices[0];
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > maxDay) {
                maxDay = prices[i];
                int profit = maxDay - minDay;
                if (profit > maxProfit) {
                    maxProfit = profit;
                }
            } else if (prices[i] < minDay) {
                minDay = maxDay = prices[i];
            }
        }
        return maxProfit;
    }
}
