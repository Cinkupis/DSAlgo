package com.pendingToSolve;

//        --------------------------------------------------------------------------------------------------------------
//        Input: deadends = ["0201","0101","0102","1212","2002"], target = "0202"
//        Output: 6
//        Explanation:
//        A sequence of valid moves would be "0000" -> "1000" -> "1100" -> "1200" -> "1201" -> "1202" -> "0202".
//        Note that a sequence like "0000" -> "0001" -> "0002" -> "0102" -> "0202" would be invalid,
//        because the wheels of the lock become stuck after the display becomes the dead end "0102".
//        --------------------------------------------------------------------------------------------------------------
//        Input: deadends = ["8888"], target = "0009"
//        Output: 1
//        Explanation:
//        We can turn the last wheel in reverse to move from "0000" -> "0009".
//        --------------------------------------------------------------------------------------------------------------
//        Input: deadends = ["8887","8889","8878","8898","8788","8988","7888","9888"], target = "8888"
//        Output: -1
//        Explanation:
//        We can't reach the target without getting stuck.
//        --------------------------------------------------------------------------------------------------------------
//        Input: deadends = ["0000"], target = "8888"
//        Output: -1
//        --------------------------------------------------------------------------------------------------------------
//        Note:
//
//        The length of deadends will be in the range [1, 500].
//        target will not be in the list deadends.
//        Every string in deadends and the string target will be a string of 4 digits from the 10,000 possibilities
//        '0000' to '9999'.
//        --------------------------------------------------------------------------------------------------------------

@SuppressWarnings("unused")
public class OpenTheLock {

    public int openLock(String[] deadEnds, String target) {

        return -1;
    }

    public static void main(String[] args) {
        OpenTheLock openTheLock = new OpenTheLock();
        String[] deadEnds = {"0201","0101","0102","1212","2002"};
        String target = "0202";
        System.out.println(openTheLock.openLock(deadEnds, target));
    }
}
