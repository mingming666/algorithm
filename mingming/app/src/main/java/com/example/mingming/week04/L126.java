package com.example.mingming.week04;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/*
* 题目： https://leetcode-cn.com/problems/word-ladder-ii/description/
* 使用bfs构建图，再使用dfs找出最短路径；
* */
public class L126 {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> ans = new ArrayList<>();
        Set<String> dict = new HashSet<>(wordList);
        if (!dict.contains(endWord)) {
            return ans;
        }
        dict.remove(beginWord);
        Map<String, Integer> steps = new HashMap<>();
        steps.put(beginWord, 0);
        Map<String, List<String>> from = new HashMap<>();
        Queue<String> que = new LinkedList<>();
        que.offer(beginWord);
        boolean found = false;
        int step = 1;
        int n = beginWord.length();
        while (!que.isEmpty()) {
            for (int i = que.size(); i > 0; i--) {
                String cur = que.poll();
                char[] arr = cur.toCharArray();
                for (int j = 0; j < n; j++) {
                    char temp = arr[j];
                    for (char c = 'a'; c <= 'z'; c++) {
                        arr[j] = c;
                        String next = String.copyValueOf(arr);
                        if (steps.containsKey(next) && steps.get(next) == step) {
                            from.get(next).add(cur);
                        }
                        if (!dict.contains(next)) {
                            continue;
                        }
                        dict.remove(next);
                        que.offer(next);
                        steps.put(next, step);
                        from.putIfAbsent(next, new ArrayList<String>());
                        from.get(next).add(cur);
                        if (next.equals(endWord)) {
                            found = true;
                        }
                    }
                    arr[j] = temp;
                }
            }
            step++;
            if (found) {
                break;
            }
        }
        if (found) {
            Deque<String> path = new LinkedList<>();
            path.offer(endWord);
            dfs(beginWord, endWord, ans, from, path);
        }
        return ans;
    }

    private void dfs(String beginWord, String cur, List<List<String>> ans, Map<String, List<String>> from, Deque<String> path) {
        if (cur.equals(beginWord)) {
            ans.add(new ArrayList<String>(path.addFirst(cur)));
            return;
        }
        for (String pre : from.get(cur)) {
            path.addFirst(pre);
            dfs(beginWord, pre, ans, from, path);
            path.removeFirst();
        }
    }
}

