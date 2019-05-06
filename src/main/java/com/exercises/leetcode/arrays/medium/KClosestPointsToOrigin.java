package com.exercises.leetcode.arrays.medium;

import java.util.PriorityQueue;

@SuppressWarnings("unused")
public class KClosestPointsToOrigin {
    private class Point {
        Double dist;
        int[] coords = new int[2];
        public Point(double d, int[] coords) {
            this.dist = d;
            this.coords = coords;
        }
    }

    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<Point> closestPoints = new PriorityQueue<Point>(K, (a, b) -> Double.compare(b.dist, a.dist));
        int[][] result = new int[K][2];

        for (int i = 0; i < points.length; i++) {
            double distance = Math.sqrt(points[i][0] * points[i][0] + points[i][1] * points[i][1]);
            Point p = new Point(distance, points[i]);
            closestPoints.offer(p);
            if (closestPoints.size() > K) {
                closestPoints.poll();
            }
        }
        int i = 0;
        while (closestPoints.size() > 0) {
            result[i++] = closestPoints.poll().coords;
        }
        return result;
    }
}
