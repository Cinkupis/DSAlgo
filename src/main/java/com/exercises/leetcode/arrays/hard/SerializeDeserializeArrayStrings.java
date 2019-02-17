package com.exercises.leetcode.arrays.hard;

@SuppressWarnings("unused")
public class SerializeDeserializeArrayStrings {
    public static String serialize(String[] arrayOfStrings) {
        StringBuilder output = new StringBuilder();

        int maxLenght = 0;
        for (String string : arrayOfStrings) {
            if (string.length() > maxLenght) {
                maxLenght = string.length();
            }
        }
        maxLenght++;
        output.append(maxLenght).append(":");

        String delimiter = generateRandString(maxLenght);
        for (String string : arrayOfStrings) {
            output.append(delimiter).append(string.length()).append(":").append(string);
        }
        System.out.println(output.toString());
        return output.toString();
    }

    public static String[] deserialize(String string, int size) {
        String[] output = new String[size];

        StringBuilder sb = new StringBuilder();
        StringBuilder num = new StringBuilder();

        int i = 0;
        while (string.charAt(i) != ':') {
            num.append(string.charAt(i));
            i++;
        }
        i++;

        int maxWordSize = Integer.valueOf(num.toString());
        num = new StringBuilder();

        boolean parsingNum = false;
        boolean parsingDelimiter = true;

        int charCount = 0;
        int nextWordLenght = 0;
        int wordCount = 0;

        while (i < string.length()) {
            if (parsingDelimiter) {
                while (charCount < maxWordSize) {
                    i++;
                    charCount++;
                }
                parsingDelimiter = false;
                parsingNum = true;
                charCount = 0;
            } else if (parsingNum) {
                while (string.charAt(i) != ':') {
                    num.append(string.charAt(i));
                    i++;
                }
                parsingNum = false;
                nextWordLenght = Integer.valueOf(num.toString());
                num = new StringBuilder();
                i++;
            } else {
                while (nextWordLenght > 0) {
                    sb.append(string.charAt(i));
                    i++;
                    nextWordLenght--;
                }
                parsingDelimiter = true;
                output[wordCount] = sb.toString();
                wordCount++;
                sb = new StringBuilder();
            }
        }
        return output;
    }

    private static String generateRandString ( int size){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append((char) (65 + (26 * Math.random())));
        }
        return sb.toString();
    }
}
