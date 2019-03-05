package com.exercises.leetcode.bitmanipulation.easy;

@SuppressWarnings("unused")
public class ReverseBytes {
    public void reverse_bytes(byte[] bytes) {
        int start = 0;
        int end = bytes.length - 1;
        while (start < end) {
            byte temp = bytes[end];
            bytes[end] = bytes[start];
            bytes[start] = temp;
            start++;
            end--;
        }

        for (int i = 0; i < bytes.length; i++) {
            bytes[i] = reverseBits(bytes[i]);
        }
    }

    private byte reverseBits(byte toReverse) {
        byte reversed = 0;
        for (int i = 0; i < 8; i++) {
            reversed += ((toReverse >>> i) & 1);
            if (i < 7) {
                reversed <<= 1;
            }
        }
        return reversed;
    }
}