package com.exercises.leetcode.arrays.easy;

@SuppressWarnings("unused")
public class CompareVersionNumbers {
    public int compareVersion(String version1, String version2) {
        String[] first = version1.split("\\.");
        String[] second = version2.split("\\.");

        int[] firstVersions = new int[first.length];
        int[] secVersions = new int[second.length];

        for (int i = 0; i < first.length; i++) {
            firstVersions[i] = Integer.parseInt(first[i]);
        }
        for (int i = 0; i < second.length; i++) {
            secVersions[i] = Integer.parseInt(second[i]);
        }

        int index = 0;
        while (index < firstVersions.length && index < secVersions.length) {
            if (firstVersions[index] < secVersions[index]) {
                return -1;
            } else if (firstVersions[index] > secVersions[index]) {
                return 1;
            } else {
                index++;
            }
        }

        int v1 = checkVersions(index, firstVersions);
        int v2 = checkVersions(index, secVersions);

        return v1 == 0 ? v2 == 0 ? 0 : -1 : 1;
    }

    private int checkVersions(int index, int[] versions) {
        if (index < versions.length) {
            for (int i = index; i < versions.length; i++) {
                if (versions[i] > 0) {
                    return 1;
                }
            }
        }
        return 0;
    }
}
