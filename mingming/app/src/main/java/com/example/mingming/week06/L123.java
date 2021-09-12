package com.example.mingming.week06;
/*
* 题目链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii/
* 题目解法：使用buy1，sell1表示第一次买卖， buy2，sell2表示第二次买卖
* */
public class L123 {
    public int maxProfit(int[] prices) {
        int buy1 = -prices[0], sell1 = 0;
        int buy2 = -prices[0], sell2 = 0;
        for (int i = 1; i < prices.length; i++) {
            buy1 = Math.max(buy1, -prices[i]);
            sell1 = Math.max(sell1, buy1 + prices[i]);
            buy2 = Math.max(buy2, sell1 - prices[i]);
            sell2 = Math.max(sell2, buy2 + prices[i]);
        }
        return  sell2;
    }
}
