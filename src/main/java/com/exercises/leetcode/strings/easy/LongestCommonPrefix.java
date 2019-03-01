package com.exercises.leetcode.strings.easy;

@SuppressWarnings("unused")
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] listOfStrings) {
        if (listOfStrings == null || listOfStrings.length == 0) {
            return "";
        }
        String commonPrefix = listOfStrings[0];
        int wordInList = 1;
        while (wordInList < listOfStrings.length) {
            while (listOfStrings[wordInList].indexOf(commonPrefix) != 0) {
                commonPrefix = commonPrefix.substring(0, commonPrefix.length() - 1);
            }
            wordInList++;
        }

        return commonPrefix;
    }
}
