package com.ruppyrup.misc.candles;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class BirthdayCandles {



    public static int birthdayCakeCandles(List<Integer> candles) {
        candles.sort(Comparator.reverseOrder());

        final Integer bob = candles.get(0);

        return (int) candles.stream()
                .peek(System.out::println)
                .filter(i -> i.equals(bob))
                .count();

    }


    public static void main(String[] args) {
        List<Integer> ints = Arrays.asList(4, 4, 1, 3);
        System.out.println(birthdayCakeCandles(ints));
        List<Integer> ints2 = Arrays.asList(3, 2, 1, 3);
        System.out.println(birthdayCakeCandles(ints2));
    }

}
