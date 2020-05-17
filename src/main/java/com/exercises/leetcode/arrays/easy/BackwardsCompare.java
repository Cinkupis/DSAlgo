package main.java.com.exercises.leetcode.arrays.easy;

@SuppressWarnings("unused")
public class BackwardsCompare {
    public boolean backspaceCompare(String S, String T) {
        char[] first = S.toCharArray();
        char[] second = T.toCharArray();
        int fIndex = first.length - 1;
        int sIndex = second.length - 1;
        while (fIndex >= 0 && sIndex >= 0) {
            fIndex = iterateBackwards(fIndex, first);
            sIndex = iterateBackwards(sIndex, second);

            if (fIndex >= 0 && sIndex >= 0 && second[sIndex] != first[fIndex]) {
                return false;
            } else if ((fIndex < 0 || sIndex < 0) && fIndex != sIndex) {
                return false;
            }
            sIndex--;
            fIndex--;
        }
        return iterateBackwards(fIndex, first) == iterateBackwards(sIndex, second);
    }

    public int iterateBackwards(int index, char[] array) {
        int skip = 0;
        while (index >= 0 && array[index] == '#') {
            while (index >= 0 && array[index] == '#') {
                index--;
                skip++;
            }
            while (index >= 0 && skip > 0 && array[index] != '#') {
                index--;
                skip--;
            }
        }
        index -= skip;
        if (index < 0) {
            return -1;
        }
        return index;
    }
}
