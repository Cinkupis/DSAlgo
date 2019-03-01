package com.algorithms.advanced;

@SuppressWarnings("unused")
public class TableOfPrefixes {
    public int[] preprocessPrefixes(String text) {
        if (text == null || text.equals("")) {
            return new int[0];
        }
        int[] table = new int[text.length()];
        table[0] = text.length();
        char[] textArray = text.toCharArray();

        int prefixStart = 1;
        int prefixEnd = 0;

        for (int i = 1; i < textArray.length; i++) {
            if (i < prefixEnd && table[i - prefixStart] != prefixEnd - i) {
                table[i] = Math.min(table[i - prefixStart], prefixEnd - i);
            } else {
                prefixEnd = Math.max(prefixEnd, i);
                prefixStart = i;

                while (prefixEnd < textArray.length && textArray[prefixEnd] == textArray[prefixEnd - prefixStart]) {
                    prefixEnd++;
                }
                table[i] = prefixEnd - prefixStart;
            }
        }
        return table;
    }
}
