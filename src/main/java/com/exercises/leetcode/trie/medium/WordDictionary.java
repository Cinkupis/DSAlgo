package com.exercises.leetcode.trie.medium;

import com.exercises.leetcode.trie.TrieNode;

@SuppressWarnings("unused")
public class WordDictionary {
    private TrieNode root = new TrieNode();

    public void addWord(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (node.children[c - 'a'] == null) {
                node.children[c - 'a'] = new TrieNode();
            }
            node = node.children[c - 'a'];
        }
        node.item = word;
    }

    public boolean search(String word) {
        return match(word.toCharArray(), 0, root);
    }

    private boolean match(char[] word, int k, TrieNode node) {
        if (k == word.length) {
            return !node.item.equals("");
        }

        if (word[k] != '.') {
            return node.children[word[k] - 'a'] != null && match(word, k + 1, node.children[word[k] - 'a']);
        } else {
            for (int i = 0; i < node.children.length; i++) {
                if (node.children[i] != null && match(word, k + 1, node.children[i])) {
                    return true;
                }
            }
        }
        return false;
    }
}
