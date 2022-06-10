package com.ruppyrup.minmax;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MinMax {
    static void miniMaxSum(int[] arr) {


        List<BigInteger> bigIntegerStream = Arrays.stream(arr).mapToObj(i -> new BigInteger(String.valueOf(i))).sorted().collect(Collectors.toList());

        BigInteger sum = bigIntegerStream.stream().reduce(BigInteger.ZERO, BigInteger::add);

        BigInteger min = sum.subtract(bigIntegerStream.get(4));
        BigInteger max = sum.subtract(bigIntegerStream.get(0));

        System.out.println(min + " " + max);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[] arr = new int[5];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < 5; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        miniMaxSum(arr);

        scanner.close();
    }
}
