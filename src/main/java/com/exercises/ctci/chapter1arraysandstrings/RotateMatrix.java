package com.exercises.ctci.chapter1arraysandstrings;

/*
    Given an image represented by an NxN matrix, where each pixel in the image is 4 bytes, write a method to rotate
    the image by 90 degrees.
 */
@SuppressWarnings("unused")
public class RotateMatrix {

    private final static byte N = 5;

    private byte[][] rotateImage (byte[][] image) {
        if (image.length == 1 && image[0].length == 1) {
            return image;
        }

        byte[][] rotatedImage = new byte[image.length][image.length];

        for (byte i = 0; i < N; i++) {
            for (byte j = 0; j < N; j++) {
                rotatedImage[i][j] = image[N - j - 1][i];
            }
        }
        return rotatedImage;
    }
}
