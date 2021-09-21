package com.example.mingming.week07;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
/*
* 题目链接：https://leetcode-cn.com/problems/minimum-genetic-mutation/submissions/
* 解决方法：双向BFS；
* */
public class L433 {
    public int minMutation(String start, String end, String[] bank) {
        Set<String> dict = new HashSet<>(Arrays.asList(bank));
        if (!dict.contains(end)) {
            return -1;
        }
        Set<String> startSet = new HashSet<>(), endSet = new HashSet<>();
        startSet.add(start);
        endSet.add(end);
        char[] factors = {'A', 'C', 'G', 'T'};
        int step = 0;
        while (!startSet.isEmpty() && !endSet.isEmpty()) {
            step++;
            if (startSet.size() > endSet.size()) {
                Set<String> set = startSet;
                startSet = endSet;
                endSet = set;
            }

            Set<String> temp = new HashSet<>();
            for (String word : startSet) {
                char[] arr = word.toCharArray();
                for (int i = 0; i < 8; i++) {
                    char old = arr[i];
                    for (int j = 0; j < 4; j++) {
                        arr[i] = factors[j];
                        String next = String.valueOf(arr);
                        if (endSet.contains(next)) {
                            return step;
                        }
                        if (dict.contains(next)) {
                            temp.add(next);
                            dict.remove(next);
                        }
                    }
                    arr[i] = old;
                }
            }
            startSet = temp;
        }
        return  -1;
    }
}
