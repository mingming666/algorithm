package com.example.mingming.week08;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
* 题目链接：https://leetcode-cn.com/problems/n-queens/description/
* 因为n <= 9 可以用int 数位运算表示;
* */
public class L51 {
    int size;
    public List<List<String>> solveNQueens(int n) {
        size = (1 << n) - 1;
        List<List<String>> ans = new ArrayList<>();
        int[] queens = new int[n];
        Arrays.fill(queens, -1);
        bactrace(ans, queens, 0, 0, 0, 0);
        return ans;
    }

    private void bactrace(List<List<String>> ans, int[] queens, int row, int col, int ld, int rd) {
        if (col == size) {
            ans.add(gen(queens));
            return;
        }
        int pos = size & (~(col | ld | rd));
        while (pos != 0) {
            int p = pos & (-pos);
            pos &= pos - 1;
            queens[row] = Integer.bitCount(p - 1);
            bactrace(ans, queens, row + 1, col | p, (ld | p) << 1, (rd | p) >> 1);
            queens[row] = -1;
        }
    }

    private List<String> gen(int[] queens) {
        int n = queens.length;
        List<String> board = new ArrayList<>(n);
        char[] row = new char[n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(row, '.');
            row[queens[i]] = 'Q';
            board.add(String.valueOf(row));
        }
        return board;
    }

}
