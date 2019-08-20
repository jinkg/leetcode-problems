package com.kinglloy.leetcode;

public class BestTimeToBuyAndSellStockIII_123 {
    public static void main(String[] args) {
        int[] prices = new int[]{1, 2, 3, 4, 5};
        System.out.println(new BestTimeToBuyAndSellStockIII_123().maxProfit(prices));
    }

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int maxPrice = 0;
        for (int i = 0; i < prices.length; i++) {
            if (i == 0 || prices[i] > prices[i - 1]) {
                int price = maxProfitOnce(prices, 0, i + 1) + maxProfitOnce(prices, i + 1, prices.length);
                if (price > maxPrice) {
                    maxPrice = price;
                }
            }
        }
        return maxPrice;
    }

    public int maxProfitOnce(int[] prices, int start, int end) {
        if (end - start < 2) {
            return 0;
        }
        int minDay = prices[start], maxDay = prices[start];
        int maxProfit = 0;

        for (int i = start + 1; i < end; i++) {
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
