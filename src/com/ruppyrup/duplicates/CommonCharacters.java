package com.ruppyrup.duplicates;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CommonCharacters {

    public List<String> commonChars(String[] words) {
        int length = words.length;
        if (length <= 1) return Arrays.asList(words);

        int[][] alphabeticChars = new int[length][26];

        for(int w = 0; w < length; w++) {
            for (int i = 0; i < words[w].length(); i++) {
                char c = words[w].charAt(i);
                int index = c - 97;
                alphabeticChars[w][index]++;
            }
        }

        List<String> result = new ArrayList<>();

        for (int i = 0; i < 26; i++) {
            int minchar = Integer.MAX_VALUE;
            for(int w = 0; w < length; w++) {
                if (alphabeticChars[w][i] <= minchar) {
                    minchar = alphabeticChars[w][i];
                }
            }
            while (minchar-- > 0) {
                char out = (char) (i + 97);
                result.add(String.valueOf(out));
            }
        }

        return result;

    }
}




class CCTest {


    private CommonCharacters cc;

    @BeforeEach
    void setUp() {
        cc = new CommonCharacters();
    }

    @Test
    void testEmpty() {
        String[] input = new String[]{};
        List<String> expected = new ArrayList<>();
        List<String> output = cc.commonChars(input);
        Assertions.assertEquals(expected, output);
    }

    @Test
    void testOne() {
        String[] input = new String[]{"hello"};
        List<String> expected = Arrays.asList(input);
        List<String> output = cc.commonChars(input);
        Assertions.assertEquals(expected, output);
    }

    @Test
    void testSeveralWords() {
        String[] input = new String[]{"cool","lock","cook"};
        String[] expectedArary = new String[]{"c", "o"};
        List<String> expected = Arrays.asList(expectedArary);
        List<String> output = cc.commonChars(input);
        Assertions.assertEquals(expected, output);
    }

    @Test
    void testSeveralWordsWithDuplicates() {
        String[] input = new String[]{"bella","label","roller"};
        String[] expectedArary = new String[]{"e", "l", "l"};
        List<String> expected = Arrays.asList(expectedArary);
        List<String> output = cc.commonChars(input);
        Assertions.assertEquals(expected, output);
    }
}
