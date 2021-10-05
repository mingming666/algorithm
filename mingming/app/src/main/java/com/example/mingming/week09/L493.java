package com.example.mingming.week09;
/*
* 题目：https://leetcode-cn.com/problems/reverse-pairs/
* 解法：归并排序过程中总翻转对 = 左翻转对 + 右翻转对 + 分别在左右数组的翻转对；
* */
public class L493 {
    public int reversePairs(int[] nums) {
        int n = nums.length;
        return n == 0 ? 0 : recursion(nums, 0, n - 1);
    }

    private int recursion(int[] nums, int l, int r) {
        if (l == r) {
            return 0;
        }
        int mid = (l + r) >> 1;
        int left = recursion(nums, l, mid);
        int right = recursion(nums, mid + 1, r);
        int res = left + right;

        int i = l, j = mid + 1;
        while (i <= mid) {
            while (j <= r && (long)nums[i] > (long)2 * nums[j]) {
                j++;
            }
            res += j - mid - 1;
            i++;
        }

        i = l;
        j = mid + 1;
        int k = 0, n = r - l + 1;
        int[] tmp = new int[n];
        while (i <= mid && j <= r) {
            tmp[k++] = nums[i] <= nums[j] ? nums[i++] : nums[j++];
        }
        while (i <= mid) tmp[k++] = nums[i++];
        while (j <= r) tmp[k++] = nums[j++];
        for (k = 0; k < n; k++) {
            nums[l + k] = tmp[k];
        }
        return res;
    }
}
