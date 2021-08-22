package com.example.mingming.week03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
* 题目：https://leetcode-cn.com/problems/permutations-ii/
* 解决方法：回溯，排除重复项，算法复杂度O(n * n!),空间复杂度O(n)
* */
public class L47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        backtrace(nums, 0, ans, new ArrayList<Integer>(nums.length), new boolean[nums.length]);
        return ans;
    }
    public void backtrace(int[] nums, int cur, List<List<Integer>> ans, List<Integer> arr, boolean[] vis) {
        if (cur == nums.length) {
            ans.add(new ArrayList<Integer>(arr));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (vis[i] || (i > 0 && nums[i] == nums[i - 1] && !vis[i - 1])) {
                continue;
            }
            vis[i] = true;
            arr.add(nums[i]);
            backtrace(nums, cur + 1, ans, arr, vis);
            vis[i] = false;
            arr.remove(cur);
        }
    }
}
