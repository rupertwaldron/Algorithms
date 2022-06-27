package com.ruppyrup.anagrams;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Anagram {


    public boolean isAnagram(String s, String t) {
        if (s.isEmpty() || t.isEmpty() || (s.length() != t.length())) return false;

        Map<Character, Integer> letters = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            Character letter = s.charAt(i);
            if (letters.containsKey(letter)) {
                letters.put(letter, letters.get(letter) + 1);
            } else {
                letters.put(letter, 1);
            }
        }

        for (int i = 0; i < t.length(); i++) {
            Character letter = t.charAt(i);
            if (letters.containsKey(letter) && letters.get(letter) >= 1) {
                int value = letters.get(letter) - 1;
                if (value == 0) {
                    letters.remove(letter);
                } else {
                    letters.put(letter, value);
                }
            } else {
                return false;
            }
        }

        return letters.isEmpty();
    }


    public boolean isAnagram2(String s, String t) {
        if (s.isEmpty() || t.isEmpty() || (s.length() != t.length())) return false;

        int[] letters = new int[26];

        for (int i = 0; i < s.length(); i++) {
            char letter = s.charAt(i);

            int index = letter - 97;

            if (letters[index] > 0) {
                letters[index]++;
            } else {
                letters[index] = 1;
            }
        }

        for (int i = 0; i < t.length(); i++) {
            char letter = t.charAt(i);
            int index = letter - 97;
            if (letters[index] >= 1) {
                letters[index]--;
            } else {
                return false;
            }
        }

        for (int i = 0; i < 26; i++) {
            if (letters[i] > 0) return false;
        }

        return true;
    }
}


class AnagramTest {

    private Anagram anagram;

    @BeforeEach
    void setUp() {
        anagram = new Anagram();
    }

    @Test
    void testEmpty() {
        String input1 = "";
        String input2 = "";
        assertFalse(anagram.isAnagram2(input1, input2));
    }

    @Test
    void testOdd() {
        String input1 = "abc";
        String input2 = "ab";
        assertFalse(anagram.isAnagram2(input1, input2));
    }

    @Test
    void testSame() {
        String input1 = "abc";
        String input2 = "abc";
        assertTrue(anagram.isAnagram2(input1, input2));
    }

    @Test
    void testWrongOrder() {
        String input1 = "aacc";
        String input2 = "ccac";
        assertFalse(anagram.isAnagram2(input1, input2));
    }

    @Test
    void testCorrectWord2() {
        String input1 = "anagram";
        String input2 = "nagaram";
        assertTrue(anagram.isAnagram2(input1, input2));
    }

    @Test
    void testCorrectWord() {
        String input1 = "restful";
        String input2 = "fluster";
        assertTrue(anagram.isAnagram2(input1, input2));
    }

}
