package com.example.mingming.week10;
/*
* 题目链接：https://leetcode-cn.com/problems/longest-valid-parentheses/
* 解法：当arr[i - 1] == ')' dp[i] = dp[i - 2] + 2, i - dp[i - 1] > 0 && arr[i - dp[i - 1] - 1] == '('时dp[i] = dp[i - 1] + (i - dp[i - 1] - 2 > 0 ? dp[i - dp[i - 1] - 2] : 0) + 2
* */
public class L32 {
    public int longestValidParentheses(String s) {
        char[] arr = s.toCharArray();
        int n = arr.length, max = 0;
        int[] dp = new int[n];
        for (int i = 1; i < n; i++) {
            if (arr[i] == ')') {
                if (arr[i - 1] == '(') {
                    dp[i] = (i > 2 ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i - 1] > 0 && arr[i - dp[i - 1] - 1] == '(') {
                    dp[i] = dp[i - 1] + (i - dp[i - 1] - 2 > 0 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
                max = Math.max(max, dp[i]);
            }
        }
        return max;
    }
}
