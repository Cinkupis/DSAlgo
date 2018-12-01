package com.dataStructures._exercises.CTCI.Chapter1_ArraysAndStrings;

/*
    Given an image represented by an NxN matrix, where each pixel in the image is 4 bytes, write a method to rotate
    the image by 90 degrees.
 */
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

    public static void main(String[] args) {
        RotateMatrix rotateMatrix = new RotateMatrix();

        // Initialize.
        byte image[][] = new byte[N][N];
        for (byte i = 0; i < N; i++) {
            for (byte j = 0; j < N; j++) {
                image[i][j] = (byte)(Math.random() * 10);
            }
        }
        // Print out original version
        for (byte i = 0; i < 2 * N + 1; i++)
            System.out.print("_");
        System.out.println();
        for (byte i = 0; i < N; i++) {
            for (byte j = 0; j < N; j++) {
                if (j == 0) {
                    System.out.print("|");
                }
                System.out.print(image[i][j] + "|");
                if (j == N - 1) {
                    System.out.println();
                }
            }
        }
        for (byte i = 0; i < 2 * N + 1; i++)
            System.out.print("-");
        System.out.println();

        // Rotate it
        image = rotateMatrix.rotateImage(image);

        // Print out the rotated version
        for (byte i = 0; i < 2 * N + 1; i++)
            System.out.print("_");
        System.out.println();
        for (byte i = 0; i < N; i++) {
            for (byte j = 0; j < N; j++) {
                if (j == 0) {
                    System.out.print("|");
                }
                System.out.print(image[i][j] + "|");
                if (j == N - 1) {
                    System.out.println();
                }
            }
        }
        for (byte i = 0; i < 2 * N + 1; i++)
            System.out.print("-");
        System.out.println();
    }
}
