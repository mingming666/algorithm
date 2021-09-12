package com.example.mingming.week06;
/*
* 题目链接：https://leetcode-cn.com/problems/edit-distance/
* 解题方法：使用二维数组dp[i][j]表示word1 长度前i个字符到word2前j个字符的最少编辑次数，word1.charAt(i - 1) == word2.charAt(j - 1)编辑距离不变
* 否则编辑距离取dp[i - 1][j], dp[i][j - 1]，dp[i - 1][j - 1]中最小者加1
* */
public class L72 {
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        if (m * n == 0) {
            return m + n;
        }
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i <= m; i++) {
            char c1 = word1.charAt(i - 1);
            for (int j = 1; j <= n; j++) {
                if ( c1 == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                }
            }
        }
        return dp[m][n];
    }
}
