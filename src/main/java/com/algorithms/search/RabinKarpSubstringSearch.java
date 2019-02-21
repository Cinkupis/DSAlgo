package com.algorithms.search;

@SuppressWarnings("unused")
public class RabinKarpSubstringSearch {

    private final static int PRIME = 173;
    private boolean ignoreCase;

    public RabinKarpSubstringSearch() {
        this(false);
    }

    public RabinKarpSubstringSearch(boolean ignoreCase) {
        this.ignoreCase = ignoreCase;
    }

    private long hash(char[] str) {
        int pow = 0;
        long hash = 0;
        for (char c : str) {
            hash += (long)Math.pow(1.0 * PRIME, pow) * c;
            pow++;
        }
        return hash;
    }

    private long nextHash(long currHash, char prev, char next, int pow) {
        return ((currHash - prev) / PRIME) + (long)(Math.pow(PRIME * 1.0, pow) * next);
    }

    public boolean contains(String originalText, String originalPattern) {
        if (originalText == null || originalPattern == null || originalText.isEmpty() || originalPattern.isEmpty() || originalText.length() < originalPattern.length()) {
            return false;
        }
        String text;
        String pattern;

        if (this.ignoreCase) {
            text = originalText.toLowerCase();
            pattern = originalPattern.toLowerCase();
        } else {
            text = originalText;
            pattern = originalPattern;
        }

        char[] searchChars = pattern.toCharArray();
        long prevHash = -1;
        char firstLetter = 0;
        long searchHash = hash(searchChars);
        long currentHash = 0;
        for (int i = 0; i < text.length() - searchChars.length + 1; i++) {
            char[] current = text.substring(i, searchChars.length + i).toCharArray();
            if (prevHash == -1) {
                currentHash = hash(current);
            } else {
                currentHash = nextHash(currentHash, firstLetter, current[current.length - 1], searchChars.length - 1);
            }

            if (currentHash == searchHash) {
                boolean isFound = true;
                for (int j = 0; j < searchChars.length; j++) {
                    if (searchChars[j] != current[j]) {
                        isFound = false;
                        break;
                    }
                }
                if (isFound) return isFound;
            }

            prevHash = currentHash;
            firstLetter = current[0];
        }

        return false;
    }

    public boolean isIgnoreCase() {
        return ignoreCase;
    }

    public void setIgnoreCase(boolean ignoreCase) {
        this.ignoreCase = ignoreCase;
    }
}
