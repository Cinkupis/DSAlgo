package com.exercises.leetcode.arrays.easy;

@SuppressWarnings("unused")
public class IslandPerimeter {
    public int islandPerimeter(int[][] grid) {
        int perimeter = 0;
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                if (grid[row][col] == 1) {
                    if (col - 1 < 0 || grid[row][col - 1] == 0) {
                        perimeter++;
                    }
                    if (col + 1 >= grid[row].length || grid[row][col + 1] == 0) {
                        perimeter++;
                    }
                    if (row - 1 < 0 || grid[row - 1][col] == 0) {
                        perimeter++;
                    }
                    if (row + 1 >= grid.length || grid[row + 1][col] == 0) {
                        perimeter++;
                    }
                }
            }
        }

        return perimeter;
    }
}
