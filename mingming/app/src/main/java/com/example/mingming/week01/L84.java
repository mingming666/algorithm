package com.example.mingming.week01;

import java.util.Deque;
import java.util.LinkedList;

public class L84 {
    public int largestRectangleArea(int[] heights) {
        Deque<Integer> stack = new LinkedList<>();
        stack.push(-1);
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            while (stack.peek() != -1 && heights[i] > heights[stack.peek()]) {
                maxArea = Math.max(maxArea, heights[stack.pop()] * (i - stack.peek() - 1));
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            maxArea = Math.max(maxArea, heights[stack.pop()] * (heights.length - 1 - stack.peek()));
        }

        return maxArea;

    }
}
