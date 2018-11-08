package DataStructures.ArraysAndStrings.Exercises;

import java.util.HashSet;
import java.util.Set;

public class IsUnique {

    private boolean isUniqueUsingSet(String input) {
        if (input == null || input.length() > 256) {
            return false;
        }
        if (input.length() < 2) {
            return true;
        }

        int setLength = 0;
        Set<String> set = new HashSet<>();
        for (int i = 0; i < input.length(); i++) {
            String currCharacter = input.substring(i, i + 1);
            set.add(currCharacter);
            if (set.size() == setLength) {
                return false;
            }
            setLength = set.size();
        }
        return true;
    }

    private boolean isUniqueUsingIndexes(String input) {
        if (input == null || input.length() > 256) {
            return false;
        }
        if (input.length() < 2) {
            return true;
        }
        for (char current : input.toCharArray()) {
            if (input.indexOf(current) != input.lastIndexOf(current)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String test = "AaBbCctyuioP";
        IsUnique isUnique = new IsUnique();
        System.out.println(isUnique.isUniqueUsingSet(test));
        System.out.println(isUnique.isUniqueUsingIndexes(test));
    }
}