package com.ruppyrup.duplicates;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.TreeMap;

public class DuplicatesInArray {


    public int[] find(final int[] input) {

        Map<Integer, Integer> frequencies = new TreeMap<>();

        for (int i = 0; i < input.length; i++) {
            if (frequencies.containsKey(input[i])) {
                frequencies.put(input[i], frequencies.get(input[i]) + 1);
            } else {
                frequencies.put(input[i], 1);
            }
        }

        int[] objects = frequencies.entrySet().stream()
                .filter(e -> e.getValue() > 1)
                .mapToInt(Map.Entry::getKey)
                .toArray();

        return objects;
    }
}


class DuplicateTest {

    private DuplicatesInArray duplicates;

    @BeforeEach
    void setup() {
        duplicates = new DuplicatesInArray();
    }

    @Test
    void testOne() {
        int[] input = new int[] {6, 9, 2, 11, 2, 1, 6, 7, 7};
        int[] output = new int[] {2, 6, 7};
        Assertions.assertArrayEquals(output, duplicates.find(input));
    }
}
