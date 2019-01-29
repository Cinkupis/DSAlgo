package com.exercises.leetcode.strings.easy;

@SuppressWarnings("unused")
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0) {
            return "";
        }
        String startsWith = strs[0];
        int i = 1;
        while(i < strs.length){
            while(strs[i].indexOf(startsWith) != 0)
                startsWith = startsWith.substring(0, startsWith.length() - 1);
            i++;
        }
        return startsWith;
    }
}
