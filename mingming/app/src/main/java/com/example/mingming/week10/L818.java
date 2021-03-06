package com.example.mingming.week10;

import java.util.Arrays;

/*
* 题目：https://leetcode-cn.com/problems/race-car/
* 解法：dp[x]表示到达位置新的最短指令长度；
* */
public class L818 {
    public int racecar(int target) {
        int[] dp = new int[target + 3];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0; dp[1] = 1; dp[2] = 4;
        for (int i = 3; i <= target; i++) {
            int k = 32 - Integer.numberOfLeadingZeros(i);
            if (i == (1 << k) - 1) {
                dp[i] = k;
                continue;
            }
            for (int j = 0; j < k; j++) {
                dp[i] = Math.min(dp[i], dp[i - (1 << (k - 1)) + (1 << j)] + k - 1 + j + 2);
            }
            if ((1 << k) - 1 - i < i) {
                dp[i] = Math.min(dp[i], dp[(1 << k) - 1 - i] + k + 1);
            }
        }
        return dp[target];
    }
}
