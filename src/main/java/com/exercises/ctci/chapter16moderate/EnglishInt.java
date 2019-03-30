package com.exercises.ctci.chapter16moderate;

import java.util.LinkedList;

@SuppressWarnings("unused")
public class EnglishInt {
    private final String[] upTo20 = new String[] {"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight",
            "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen",
            "Seventeen", "Eighteen", "Nineteen"};
    private final String[] upTo100 = new String[] {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy",
            "Eighty", "Ninety"};
    private final String[] upToBigs = new String[] {"", "Thousand", "Million", "Billion"};
    private final String hundred = "Hundred";
    private final String negative = "Negative";

    private StringBuilder stringBuilder;

    public String numberToWords(int number) {
        stringBuilder = new StringBuilder();
        if (number == 0) {
            return upTo20[0];
        }

        if (number < 0) {
            return negative + " " + numberToWords(-1 * number);
        }

        LinkedList<String> parts = new LinkedList<>();
        int chunkCount = 0;

        while (number > 0) {
            if (number % 1000 != 0) {
                String chunk = convertChunk(number % 1000);
                if (chunkCount > 0) {
                    chunk += " " + upToBigs[chunkCount];
                }
                parts.addFirst(chunk);
            }
            number /= 1000;
            chunkCount++;
        }
        return listToString(parts);
    }

    private String convertChunk(int number) {
        LinkedList<String> parts = new LinkedList<>();

        if (number >= 100) {
            parts.addLast(upTo20[number / 100]);
            parts.addLast(hundred);
            number %= 100;
        }

        if (number >= 10 && number <= 19) {
            parts.addLast(upTo20[number]);
        } else if (number >= 20) {
            parts.addLast(upTo100[number / 10]);
            number %= 10;
        }

        if (number >= 1 && number <= 9) {
            parts.addLast(upTo20[number]);
        }

        return listToString(parts);
    }

    private String listToString(LinkedList<String> parts) {
        StringBuilder sb = new StringBuilder();
        while (parts.size() > 1) {
            sb.append(parts.poll());
            sb.append(" ");
        }
        sb.append(parts.poll());
        return sb.toString();
    }
}
