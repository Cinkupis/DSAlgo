package com.algorithms.sort;

/*
Best Case: O(n + k(
Average Case: O(n + k)
Worst Case: O(n^2)
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SuppressWarnings("unused")
public class BucketSort {
    public static void bucketSort(int[] input) {
        // get hash codes
        final int[] code = hash(input);

        // create and initialize buckets to ArrayList: O(n)
        List<Integer>[] buckets = new List[code[1]];
        for (int i = 0; i < code[1]; i++) {
            buckets[i] = new ArrayList();
        }

        // distribute data into buckets: O(n)
        for (int i : input) {
            buckets[hash(i, code)].add(i);
        }

        // sort each bucket O(n)
        for (List bucket : buckets) {
            Collections.sort(bucket);
        }

        int ndx = 0;
        // merge the buckets: O(n)
        for (int b = 0; b < buckets.length; b++) {
            for (int v : buckets[b]) {
                input[ndx++] = v;
            }
        }
    }

    private static int[] hash(int[] input) {
        int m = input[0];
        for (int i = 1; i < input.length; i++) {
            if (m < input[i]) {
                m = input[i];
            }
        }
        return new int[] { m, (int) Math.sqrt(input.length) };
    }

    private static int hash(int i, int[] code) {
        return (int) ((double) i / code[0] * (code[1] - 1));
    }
}
