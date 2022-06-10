package com.ruppyrup.strings;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class PartitionLabelsTest {

    private PartitionLabels partitionLabels;

    @BeforeEach
    void setUp() {
        partitionLabels = new PartitionLabels();
    }

    @Test
    void singleElementTest() {
        String input = "a";
        Integer[] expected = new Integer[] {1};
        assertArrayEquals(expected, partitionLabels.partitionLabels(input).toArray(new Integer[0]));
    }

    @Test
    void noElementTest() {
        String input = "";
        Integer[] expected = new Integer[] {};
        assertArrayEquals(expected, partitionLabels.partitionLabels(input).toArray(new Integer[0]));
    }

    @Test
    void singleLetterTest() {
        String input = "abc";
        Integer[] expected = new Integer[] {1, 1, 1};
        assertArrayEquals(expected, partitionLabels.partitionLabels(input).toArray(new Integer[0]));
    }

    @Test
    void threeLetterTest() {
        String input = "aaa";
        Integer[] expected = new Integer[] {3};
        assertArrayEquals(expected, partitionLabels.partitionLabels(input).toArray(new Integer[0]));
    }

    @Test
    void differentLetterNoPartitionTest() {
        String input = "eccbbbbdec";
        Integer[] expected = new Integer[] {10};
        assertArrayEquals(expected, partitionLabels.partitionLabels(input).toArray(new Integer[0]));
    }

    @Test
    void differentLetterNoPartitionTest2() {
        String input = "ababcbacadefegdehijhklij";
        Integer[] expected = new Integer[] {9, 7, 8};
        assertArrayEquals(expected, partitionLabels.partitionLabels(input).toArray(new Integer[0]));
    }
}
