package com.example.mingming.week01;

import java.util.Deque;
import java.util.LinkedList;

public class L42 {
    public int trap(int[] height) {
        Deque<Integer> stack = new LinkedList<>();
        int ans = 0;
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int top = height[stack.pop()];
                if (stack.isEmpty()) {
                    break;
                }
                int w = i - stack.peek() - 1;
                int h = Math.min(height[stack.peek()],height[i]) - top;
                ans += w * h;
            }
            stack.push(i);
        }
        return  ans;
    }

}
