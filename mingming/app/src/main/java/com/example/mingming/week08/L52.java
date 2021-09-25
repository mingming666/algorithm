package com.example.mingming.week08;
/*
* 题目链接：https://leetcode-cn.com/problems/n-queens-ii/description/
* 解决方法：因为n<=9, 所以可以用int数表示
* */
public class L52 {
    int size, count;
    public int totalNQueens(int n) {
        size = (1 << n) - 1;
        count = 0;
        dfs(0, 0, 0);
        return count;
    }

    private void dfs(int col, int ld, int rd) {
        if (col == size) {
            count++;
            return;
        }
        int pos = size & (~(col | ld | rd));
        while (pos != 0) {
            int p = pos & (-pos);
            pos &= pos - 1;
            dfs(col | p, (ld | p) << 1, (rd | p) >> 1);
        }
    }
}
