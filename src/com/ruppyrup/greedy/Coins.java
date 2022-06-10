package com.ruppyrup.greedy;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;


public class Coins {

    private static List<List<Long>> sucesses = new LinkedList<>();

    private static List<List<Long>> previousResults = new LinkedList<>();

    public static long getWays(int n, List<Long> c) {
        final List<Long> sorted = c.stream().sorted().collect(Collectors.toList());
        List<Long> change = new ArrayList<>();
        return solveCoins(n, sorted, change);
    }



    private static boolean alreadyStored(List<Long> attempt, List<List<Long>> stored) {
        final List<Long> sortedAttempt = attempt.stream().sorted().collect(Collectors.toList());
        for (List<Long> store : stored) {
            if (store.equals(sortedAttempt)) return true;
        }
        return false;
    }

    private static long solveCoins(int target, List<Long> coins, List<Long> change) {
        final Long changeSum = change.stream().reduce(0L, Long::sum);
        System.out.println(change + " :: " + changeSum);
        if (changeSum == target) {
            sucesses.add(change.stream().sorted().collect(Collectors.toList()));
            return 1L;
        }
        else if (changeSum > target) {
            return 0L;
        }
        else {
            long sum = 0L;
            for (int i = 0; i < coins.size(); i++) {
                List<Long> temp = new ArrayList<>(change);
                temp.add(coins.get(i));
                if (alreadyStored(temp, sucesses) || changeSum + coins.get(i) > target) continue;
                if (alreadyStored(temp, previousResults)) continue;
                previousResults.add(temp);
                sum += solveCoins(target, coins, temp);
            }
            return sum;
        }
    }


    public static int coinChange(int[] coins, int amount) {
        List<Long> longCoins = Arrays.stream(coins).asLongStream().boxed().collect(Collectors.toList());
       getWays(amount, longCoins);
       if (sucesses.isEmpty()) return -1;
       int min = Integer.MAX_VALUE;
       for (List<Long> result : sucesses) {
           if (result.size() < min) min = result.size();
       }
       return min;
    }
}

class Solution {
    public static void main(String[] args) throws IOException {

        int n = 10;
        List<Long> c = List.of(2L, 5L, 3L, 6L);
        long ways = Coins.getWays(n, c);
        System.out.println("Answer = " + ways);

        int[] coins = {2, 5, 3, 6};

        System.out.println(Coins.coinChange(coins, n));

    }
}

