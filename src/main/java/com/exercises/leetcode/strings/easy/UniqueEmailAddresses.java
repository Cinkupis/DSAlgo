package com.exercises.leetcode.strings.easy;

import java.util.HashSet;
import java.util.Set;

@SuppressWarnings("unused")
public class UniqueEmailAddresses {
    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < emails.length; i++) {
            String[] email = emails[i].split("@");
            String proper = email[0].split("\\+")[0].replaceAll("\\.", "") + "@" + email[1];
            set.add(proper);
        }
        return set.size();
    }
}
