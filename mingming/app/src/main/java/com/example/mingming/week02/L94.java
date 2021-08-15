package com.example.mingming.week02;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/*
* 题目：https://leetcode-cn.com/problems/chou-shu-lcof/
* 题解方法：
* 1. 从小到大计算丑数，使用Set排除重复，计数到第n个, 时间复杂度O(nlog n), 空间复杂度O(n)
* 2. 动态规划, 时间复杂度O(n)，空间复杂度O(1)
* */
public class L94 {
    public int nthUglyNumber(int n) {
        int[] factors = {2, 3, 5};
        Set<Long> set = new HashSet<>();
        PriorityQueue<Long> heap = new PriorityQueue<>();
        heap.offer(1L);
        set.add(1L);
        int ugly = 0;
        for (int i = 0; i < n; i++) {
            long cur = heap.poll();
            ugly = (int)cur;
            for (int factor : factors) {
                Long next = cur * factor;
                if (set.add(next)) {
                    heap.offer(next);
                }
            }
        }
        return ugly;
    }

    public int nthUglyNumberDp(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        int p2 = 1, p3 = 1, p5 = 1;
        for (int i = 2; i <= n; i++) {
            int num2 = dp[p2] * 2;
            int num3 = dp[p3] * 3;
            int num5 = dp[p5] * 5;
            dp[i] = Math.min(Math.min(num2, num3), num5);
            if (dp[i] == num2) {
                p2++;
            }
            if (dp[i] == num3) {
                p3++;
            }
            if (dp[i] == num5) {
                p5++;
            }
        }
        return dp[n];
    }
}
