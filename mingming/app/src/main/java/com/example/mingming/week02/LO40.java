package com.example.mingming.week02;

import java.util.Comparator;
import java.util.PriorityQueue;
/*
题目 ： https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/
       解决办法：
       1. 使用快排，复杂度O(nlog n),空间复杂度O(log n);
       2. 维护一个大小为k的大顶堆，算法复杂度O(nlog k),空间复杂度 O(k);
*/



public class LO40 {
    public int[] getLeastNumbers(int[] arr, int k) {
        int[] ans = new int[k];
        if (k == 0) {
            return ans;
        }
        PriorityQueue<Integer> heap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int i = 0; i < k; i++) {
            heap.offer(arr[i]);
        }
        for (int i = k; i < arr.length; i++) {
            if (heap.peek() > arr[i]) {
                heap.poll();
                heap.offer(arr[i]);
            }
        }
        for (int i = 0; i < k; i++) {
            ans[i] = heap.poll();
        }
        return ans;

    }
}
