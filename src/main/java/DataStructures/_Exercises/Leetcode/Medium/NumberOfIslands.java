package DataStructures._Exercises.Leetcode.Medium;

import java.awt.*;
import java.util.LinkedList;

//----------------
//        Input:
//        11110
//        11010
//        11000
//        00000
//
//        Output:1
//----------------
//        Input:
//        11000
//        11000
//        00100
//        00011
//
//        Output:3
//----------------

public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        short islandCount = 0;
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return islandCount;
        }

        short height = (short)grid.length;
        short width = (short)grid[0].length;
        short[] xOffset = {0, 1, 0, -1};
        short[] yOffset = {1, 0, -1, 0};
        LinkedList nodesToCheck = new LinkedList<Point>();
        LinkedList visitedNodes = new LinkedList<Point>();

        for (short x = 0; x < height; x++) {
            for (short y = 0; y < width; y++) {
                if (grid[x][y] == '1') {
                    nodesToCheck.add(new Point(x, y));
                }
            }
        }

        while (!nodesToCheck.isEmpty()) {
            islandCount++;
            Point currentNode = (Point) nodesToCheck.pop();
            visitedNodes.add(currentNode);
            while (!visitedNodes.isEmpty()) {
                currentNode = (Point) visitedNodes.pop();
                for (int i = 0; i < 4; i++) {
                    Point neighbourNode = new Point(currentNode.x + xOffset[i], currentNode.y + yOffset[i]);
                    if (neighbourNode.x >= 0 && neighbourNode.x < height && neighbourNode.y >= 0 && neighbourNode.y < width && nodesToCheck.contains(neighbourNode)) {
                        nodesToCheck.remove(neighbourNode);
                        visitedNodes.add(neighbourNode);
                    }
                }
            }
        }

        return islandCount;
    }

    public static void main(String[] args) {
        NumberOfIslands numberOfIslands = new NumberOfIslands();
        char[][] input = {{'1','1','1','1','0'},
                          {'1','1','0','1','0'},
                          {'1','1','0','0','0'},
                          {'0','0','0','0','0'}};

        int number = numberOfIslands.numIslands(input);
        System.out.print(number);
    }
}
