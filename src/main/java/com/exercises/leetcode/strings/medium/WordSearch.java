package com.exercises.leetcode.strings.medium;

@SuppressWarnings("unused")
public class WordSearch {
    public boolean exist(char[][] board, String word) {
        char[] letterArray = word.toCharArray();
        for (int y = 0; y < board.length; y++) {
            for (int x = 0; x < board[y].length; x++) {
                if (exist(board, y, x, letterArray, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean exist(char[][] board, int y, int x, char[] letterArray, int index) {
        if (index == letterArray.length) {
            return true;
        }

        if (y < 0 || x < 0 || y == board.length || x == board[y].length) {
            return false;
        }

        if (board[y][x] != letterArray[index]) {
            return false;
        }

        // "mark" as visited
        board[y][x] ^= 256;

        boolean wordExists = exist(board, y, x + 1, letterArray, index + 1)
                || exist(board, y, x - 1, letterArray, index + 1)
                || exist(board, y + 1, x, letterArray, index + 1)
                || exist(board, y - 1, x, letterArray, index + 1);

        // "unmark"
        board[y][x] ^= 256;
        return wordExists;
    }
}
