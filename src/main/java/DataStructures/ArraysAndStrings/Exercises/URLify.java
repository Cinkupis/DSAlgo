package DataStructures.ArraysAndStrings.Exercises;

/*
    Write a method to replace all spaces in a char array with '%20'. You may assume that the char array has sufficient
    space at the end to hold the additional characters, and that you are given the "true" length of the string.
    Do not use Java Strings.
 */
public class URLify {
    private String urlify(char[] originalString, int actualLength) {
        int spaceCount = 0;
        for (int i = 0; i < actualLength; i++) {
            if (originalString[i] == ' ') {
                spaceCount++;
            }
        }
        int index = actualLength + spaceCount * 2;
        for (int i = actualLength - 1; i >= 0; i--) {
            if (originalString[i] == ' ') {
                originalString[--index] = '0';
                originalString[--index] = '2';
                originalString[--index] = '%';
            } else {
                originalString[--index] = originalString[i];
            }
        }

        return String.copyValueOf(originalString);
    }

    public static void main(String[] args) {
        URLify url = new URLify();
        System.out.print(url.urlify("Mr John Smith     ".toCharArray(), 13));
    }
}
