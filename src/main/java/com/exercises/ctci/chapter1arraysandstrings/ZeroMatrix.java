package com.exercises.ctci.chapter1arraysandstrings;

/*
    Write an algorithm such that if an element in an MxN matrix is 0, its entire row and column are set to 0.
 */
@SuppressWarnings("unused")
public class ZeroMatrix {

    private final static byte N = 5;
    private final static byte M = 10;

    private int[][] zeroOutRowColumn(int[][] matrix) {
        boolean rowHasZero = false;
        boolean colHasZero = false;

        for (int j = 0; j < matrix[0].length; j++) {
            if (matrix[0][j] == 0) {
                rowHasZero = true;
                break;
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                colHasZero = true;
                break;
            }
        }

        for (int i = 1; i < matrix.length; i++)
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }

        for (int i = 1; i < matrix.length; i++)
            if (matrix[i][0] == 0)
                nullifyRow(matrix, i);

        for (int j = 1; j < matrix[0].length; j++)
            if (matrix[0][j] == 0)
                nullifyColumn(matrix, j);

        if (rowHasZero)
            nullifyRow(matrix, 0);

        if (colHasZero)
            nullifyColumn(matrix, 0);
        return matrix;
    }

    private void nullifyRow(int[][] matrix, int row) {
        for (int j = 0; j < matrix[0].length; j++) {
            matrix[row][j] = 0;
        }
    }

    private void nullifyColumn(int[][] matrix, int col) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][col] = 0;
        }
    }
}
