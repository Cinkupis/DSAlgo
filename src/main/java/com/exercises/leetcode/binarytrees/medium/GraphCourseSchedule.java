package com.exercises.leetcode.binarytrees.medium;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
public class GraphCourseSchedule {
    private List<List<Integer>> courseSchedule;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        courseSchedule = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            courseSchedule.add(new ArrayList<>());
        }
        for (int i = 0; i < prerequisites.length; i++) {
            courseSchedule.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }

        boolean[] visited = new boolean[numCourses];
        boolean[] backwardStack = new boolean[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (nodeHasCycle(i, visited, backwardStack)) {
                return false;
            }
        }

        return true;
    }

    private boolean nodeHasCycle(int course, boolean[] visited, boolean[] backwardStack) {
        if (backwardStack[course]) {
            return true;
        }

        if (visited[course]) {
            return false;
        }

        visited[course] = true;
        backwardStack[course] = true;

        List<Integer> prerequisites = courseSchedule.get(course);
        for (Integer requirement : prerequisites) {
            if (nodeHasCycle(requirement, visited, backwardStack)) {
                return true;
            }
        }
        backwardStack[course] = false;

        return false;
    }
}
