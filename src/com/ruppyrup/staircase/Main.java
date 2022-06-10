package com.ruppyrup.staircase;

import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        staircase(n);

        scanner.close();
    }

    private static void staircase(int n) {
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < n - j - 1; i++) {
                System.out.print(" ");
            }
            for (int k = 0; k <= j; k++) {
                System.out.print("#");
            }
            System.out.println();
        }

    }
}

