package com.datastructures.bitmanipulation;

@SuppressWarnings("unused")
public class BitOps {
    public static boolean getBit(int number, int index) {
        return ((number & (1 << index)) != 0);
    }

    public static int setBit(int number, int index) {
        return number | (1 << index);
    }

    public static int clearBit(int number, int index) {
        int mask = ~(1 << index);
        return number & mask;
    }

    public static int clearBitsMSBThroughIndex(int number, int index) {
        int mask = (1 << index) - 1;
        return number & mask;
    }

    public static int clearBitsIndexThrough0(int number, int index) {
        int mask = (-1 << (index + 1));
        return number & mask;
    }

    public static int updateBit(int number, int index, boolean isBit1) {
        int value = isBit1 ? 1 : 0;
        int mask = ~(1 << index);
        return (number & mask) | (value << index);
    }
}
