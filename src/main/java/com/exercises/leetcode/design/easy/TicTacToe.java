package com.exercises.leetcode.design.easy;

@SuppressWarnings("unused")
public class TicTacToe {
    private class PlayerMoves {
        int[] rows;
        int[] cols;
        int diag1 = 0;
        int diag2 = 0;
    }

    int size;
    int moves = 0;
    int limit = 0;
    PlayerMoves[] players = new PlayerMoves[2];

    public TicTacToe(int n) {
        size = n;
        limit = 2 * n - 1;
        players[0] = new PlayerMoves();
        players[0].rows = new int[size];
        players[0].cols = new int[size];

        players[1] = new PlayerMoves();
        players[1].rows = new int[size];
        players[1].cols = new int[size];
    }

    public int move(int row, int col, int player) {
        moves++;
        players[player - 1].rows[row]++;
        players[player - 1].cols[col]++;
        if (row == col && row == size / 2) {
            players[player - 1].diag1++;
            players[player - 1].diag2++;
        } else if (row == col) {
            players[player - 1].diag1++;
        } else if (row + col == size - 1) {
            players[player - 1].diag2++;
        }

        if (players[player - 1].rows[row] == size || players[player - 1].cols[col] == size || players[player - 1].diag1 == size || players[player - 1].diag2 == size) {
            return player;
        }
        return 0;
    }
}
