package com.example.mingming.week07;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
* 题目链接： https://leetcode-cn.com/problems/word-search-ii/
* 解法：构建Trie树，回溯查找
* */
public class L212 {
    public static class Trie{
        Map<Character, Trie> children = new HashMap<>();
        String word = null;
    }
    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};
    public List<String> findWords(char[][] board, String[] words) {
        Trie root = new Trie();
        for (String word : words) {
            Trie node = root;
            for (char letter : word.toCharArray()) {
                if (node.children.containsKey(letter)) {
                    node = node.children.get(letter);
                } else {
                    Trie newNode = new Trie();
                    node.children.put(letter, newNode);
                    node = newNode;
                }
            }
            node.word = word;
        }
        List<String> ans = new ArrayList<>();
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (root.children.containsKey(board[i][j])) {
                    backtrace(board, i, j, root, ans);
                }
            }
        }
        return ans;
    }

    private void backtrace(char[][] board, int i, int j, Trie root, List<String> ans) {
        char letter = board[i][j];
        Trie node = root.children.get(letter);
        if (node.word != null) {
            ans.add(node.word);
            node.word = null;
        }
        board[i][j] = '#';
        for (int k = 0; k < 4; k++) {
            int ni = i + dy[k];
            int nj = j + dx[k];
            if (ni < 0 || ni >= board.length || nj < 0 || nj >= board[0].length) {
                continue;
            }
            if (node.children.containsKey(board[ni][nj])) {
                backtrace(board, ni, nj, node, ans);
            }
        }
        board[i][j] = letter;
        if (node.children.isEmpty()) {
            root.children.remove(letter);
        }
    }

}

