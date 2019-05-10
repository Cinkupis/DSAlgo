package com.exercises.leetcode.strings.easy;

@SuppressWarnings("unused")
public class LicenceKeyFormatting {
    public String licenseKeyFormatting(String S, int K) {
        char[] s = S.toUpperCase().replace("-", "").toCharArray();
        StringBuilder sb = new StringBuilder();
        int k = K;

        for (int i = s.length - 1; i >= 0; i--) {
            if (k == 0) {
                sb.append("-");
                k = K;
            }
            sb.append(s[i]);
            k--;
        }

        char[] res = sb.toString().toCharArray();
        int low = 0;
        int high = res.length - 1;

        while (low <= high) {
            char temp = res[low];
            res[low] = res[high];
            res[high] = temp;
            low++;
            high--;
        }

        return new String(res);
    }
}
