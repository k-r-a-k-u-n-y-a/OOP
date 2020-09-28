package com.company;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Input string: ");
        Scanner input = new Scanner(System.in);
        String str = input.nextLine();

        int maxBlockLength = searchMaxBlockLength(str);
        System.out.println("Max block length = " + maxBlockLength);
    }

    private static int searchMaxBlockLength(String str) {
        int counter = 1;
        int maxCounter = 0;

        for (int i = 0; i < str.length() - 1; ++i) {
            if (str.charAt(i) == str.charAt(i + 1)) {
                counter++;
            }
            else {
                counter = 1;
            }

            if (counter > maxCounter) {
                maxCounter = counter;
            }
        }

        return maxCounter;
    }
}
