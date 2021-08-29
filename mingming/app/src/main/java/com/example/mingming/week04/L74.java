package com.example.mingming.week04;
/*
* 题目链接：https://leetcode-cn.com/problems/search-a-2d-matrix/
* 题解：二维矩阵使用二分查找， 算法复杂度：log(m*n)
* */
public class L74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int l = 0, r = m * n - 1, mid, guess;
        while(l <= r) {
            mid = (r - l) / 2 + l;
            guess = matrix[mid / n][mid % n];
            if (guess < target) {
                l = mid + 1;
            } else if (guess > target) {
                r = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
