package com.exercises.leetcode.arrays.easy;

import java.util.HashSet;
import java.util.Set;

@SuppressWarnings("unused")
public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            Set<Character> duplicateCheck = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    if (duplicateCheck.contains(board[i][j])) {
                        return false;
                    } else {
                        duplicateCheck.add(board[i][j]);
                    }
                }
            }
        }

        for (int i = 0; i < 9; i++) {
            Set<Character> duplicateCheck = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                if (board[j][i] != '.') {
                    if (duplicateCheck.contains(board[j][i])) {
                        return false;
                    } else {
                        duplicateCheck.add(board[j][i]);
                    }
                }
            }
        }

        int jump = 3;
        for (int i = 0; i < 9; i = i + jump) {
            for (int j = 0; j < 9; j = j + jump) {
                Set<Character> duplicateCheck = new HashSet<>();
                for (int x = i; x < i + jump; x++) {
                    for (int y = j; y < j + jump; y++) {
                        if (board[x][y] != '.') {
                            if (duplicateCheck.contains(board[x][y])) {
                                return false;
                            } else {
                                duplicateCheck.add(board[x][y]);
                            }
                        }
                    }
                }
            }
        }

        return true;
    }
}
