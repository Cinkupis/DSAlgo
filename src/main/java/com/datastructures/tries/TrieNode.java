package com.datastructures.tries;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("unused")
public class TrieNode {
    Map<Character, TrieNode> map = new HashMap<>();
    boolean endOfWord = false;
}
