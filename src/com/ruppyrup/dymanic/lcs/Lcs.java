package com.ruppyrup.dymanic.lcs;

import java.util.ArrayList;
import java.util.Arrays;

public class Lcs {

    public int lcs(String s1, String s2) {

        // 2D array to memoize sub-results
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];

        // running time is O(m*n)

        for (int i = 1; i < s1.length() + 1; i++) {
            for (int j = 1; j < s2.length() + 1; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    // take the diagonal value
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[s1.length()][s2.length()];

        // Find the longest sequence
//        String lcs = "";
//        int i = s1.length();
//        int j = s2.length();
//
//        while (i > 0 && j > 0) {
//            if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
//                lcs += s1.charAt(i - 1);
//                i -= 1;
//                j -= 1;
//            } else if (dp[i - 1][j] > dp[i][j - 1]) {
//                i -= 1;
//            } else {
//                j -= 1;
//            }
//        }
//
//        return new StringBuilder(lcs).reverse().toString();
    }

    public static void main(String[] args) {
        Lcs lcs = new Lcs();
        System.out.println(lcs.lcs("oxcpqrsvwf", "shmtulqrypy"));
    }
}
