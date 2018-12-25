package com.exercises.CTCI.Chapter1_ArraysAndStrings;

/*
    There are three types of edits that can be performed on strings: insert a character, remove a character, or replace
    a character. Given two strings, write a function to check if they are one or zero edits away.

    EXAMPLE:
    pale, ple -> true
    pales, pale -> true
    pale, bale -> true
    pape, pepa -> false
    pale, bake -> false
 */
public class OneAway {

    private boolean oneOrZeroEditsAway(String one, String two) {
        if (one == null || two == null || one.isEmpty() || two.isEmpty() || Math.abs(one.length() - two.length()) > 1) {
            return false;
        }

        if (one.contains(two) || two.contains(one)) {
            return true;
        }

        int editsAway = 0;
        int shortestStringLength = Math.min(one.length(), two.length());
        for (int i = 0; i < shortestStringLength; i++) {
            if (one.charAt(i) != two.charAt(i) &&
                    (one.length() > two.length() && one.charAt(i + 1) != two.charAt(i) ||
                    two.length() > one.length() && two.charAt(i + 1) != one.charAt(i) ||
                    one.length() == two.length())) {
                editsAway++;
            }
            if (editsAway > 1) {
                return false;
            }
        }

        if (editsAway == 1 && one.length() == two.length()) {
            return true;
        } else if (editsAway == 0 && one.length() != two.length()) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        OneAway oneAway = new OneAway();
        System.out.print(oneAway.oneOrZeroEditsAway("pale", "sale")); // false
    }
}
