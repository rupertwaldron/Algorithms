package com.ruppyrup.anagrams;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Sherlock {


    static void checkMagazine(String[] magazine, String[] note) {

        Map<String, Integer> mag = new HashMap<>();
        for (String str : magazine) {
            if (mag.containsKey(str)) mag.put(str, mag.get(str) + 1);
            else mag.put(str, 1);
        }

        boolean missingWord = false;

        for (String str : note) {
            if (mag.containsKey(str) && mag.get(str) > 0) {
                mag.put(str, mag.get(str) - 1);
            } else {
               missingWord = true;
            }
        }

        String output = missingWord ? "No" : "Yes";

        System.out.println(output);

    }


    public static void main(String[] args) {
        String[] mag = {"ive","got","a","lovely","bunch","of","coconuts"};
        String[] note = {"ive","got","lovely","coconuts"};
        checkMagazine(mag, note);
    }
}
