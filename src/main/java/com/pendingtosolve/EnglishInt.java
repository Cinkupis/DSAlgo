package com.pendingtosolve;

/*
    Given any integer, print an English phrase that describes the integer (e.g. "One Thousand, Two Hundred Thirty Four").
 */
@SuppressWarnings("unused")
public class EnglishInt {
    private final String[] upTo20 = new String[] {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight",
            "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen",
            "Nineteen"};
    private final String[] upTo100 = new String[] {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy",
            "Eighty", "Ninety"};
    private final String[] upToBigs = new String[] {"Hundred", "Thousand", "Million", "Billion"};
    private final String negative = "Negative";
    private final String zero = "Zero";
    private StringBuilder stringBuilder;

    public EnglishInt() {}

    public String translate(int number) {
        stringBuilder = new StringBuilder();
        if (number == 0) {
            return zero;
        }

        if (number < 0) {
            stringBuilder.append(negative);
            stringBuilder.append(" ");
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        EnglishInt englishInt = new EnglishInt();
        System.out.println(englishInt.translate(1234));
    }
}
