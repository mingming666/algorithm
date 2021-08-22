package com.example.mingming.week03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
/*
*题目：https://leetcode-cn.com/problems/n-queens/submissions/
* 解题方法：回溯，将同一列，左右对焦线上有Q的情况排除，算法复杂度O(N!)， 递归n层，空间复杂度O(N)
*  */
public class L51 {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        int[] queens = new int[n];
        Arrays.fill(queens, -1);
        backtrace(n, 0, ans, queens, new HashSet<Integer>(), new HashSet<Integer>(), new HashSet<Integer>());
        return ans;
    }

    public void backtrace(int n, int row, List<List<String>> ans, int[] queens, HashSet<Integer> col, HashSet<Integer> dia1, HashSet<Integer> dia2) {
        if (row == n) {
            ans.add(gen(n, queens));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (col.contains(i)) {
                continue;
            }
            int diagonal1 = row - i;
            if (dia1.contains(diagonal1)) {
                continue;
            }
            int diagonal2 = row + i;
            if (dia2.contains(diagonal2)) {
                continue;
            }
            queens[row] = i;
            col.add(i);
            dia1.add(diagonal1);
            dia2.add(diagonal2);
            backtrace(n, row + 1, ans, queens, col, dia1, dia2);
            queens[row] = -1;
            col.remove(i);
            dia1.remove(diagonal1);
            dia2.remove(diagonal2);
        }
    }

    public List<String> gen(int n, int[] queens) {
        List<String> board = new ArrayList<>(n);
        char[] row = new char[n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(row, '.');
            row[queens[i]] = 'Q';
            board.add(new String(row));
        }
        return board;
    }
}
