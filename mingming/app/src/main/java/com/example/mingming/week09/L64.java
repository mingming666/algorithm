package com.example.mingming.week09;
/*
* 题目：https://leetcode-cn.com/problems/minimum-path-sum/
* 题解：使用dp[i][j]表示到网格grid[i][j]路径上数字和的最小值，dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j],可以压缩维度dp[j] = Math.min(dp[j - 1], dp[j]) + grid[i][j]
* * */
public class L64 {
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[] dp = new int[n];
        dp[0] = grid[0][0];
        for (int i = 1; i < n; i++) {
            dp[i] = dp[i - 1] + grid[0][i];
        }
        for (int i = 1; i < m; i++) {
            dp[0] += grid[i][0];
            for (int j = 1; j < n; j++) {
                dp[j] = Math.min(dp[j - 1], dp[j]) + grid[i][j];
            }
        }
        return dp[n - 1];
    }
}
