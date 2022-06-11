package com.ruppyrup.stacks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Deque;
import java.util.LinkedList;

public class ValidParenthesis {

    public boolean isValid(String s) {
        if (s.length() <= 1) return false;

        Deque<Character> forwardBrackets = new LinkedList<>();

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{')  forwardBrackets.push(c);
            if (c == ')' || c == ']' || c == '}')  {
                if (forwardBrackets.isEmpty()) return false;
                Character pop = forwardBrackets.pop();
                if (pop != swapreverse(c)) {
                    return false;
                }
            }
        }

        return forwardBrackets.isEmpty();
    }

    private char swapreverse(char reverseBracket) {
        switch (reverseBracket) {
            case ')':
                return '(';
            case ']':
                return '[';
            case '}':
                return '{';
            default:
                throw new IllegalStateException("Unexpected value: " + reverseBracket);
        }
    }
}


class ValidParenthesisTest {

    private ValidParenthesis validParenthesis = new ValidParenthesis();

    @Test
    void noBracketsTest() {
        boolean valid = validParenthesis.isValid("");
        Assertions.assertFalse(valid);
    }

    @Test
    void singleBracketsTest() {
        boolean valid = validParenthesis.isValid("(");
        Assertions.assertFalse(valid);
    }

    @Test
    void doubleBracketsTest() {
        boolean valid = validParenthesis.isValid("()");
        Assertions.assertTrue(valid);
    }

    @Test
    void doubleOddBracketsTest() {
        boolean valid = validParenthesis.isValid("((");
        Assertions.assertFalse(valid);
    }

    @Test
    void differentLetterNoPartitionTest() {
        boolean valid = validParenthesis.isValid("(]");
        Assertions.assertFalse(valid);
    }

    @Test
    void multipleBracketsTest() {
        boolean valid = validParenthesis.isValid("(([]))");
        Assertions.assertTrue(valid);
    }

    @Test
    void multipleBracketsTest2() {
        boolean valid = validParenthesis.isValid("()[]{}");
        Assertions.assertTrue(valid);
    }

    @Test
    void multipleBracketsTest3() {
        boolean valid = validParenthesis.isValid("(({{[[]]}}))");
        Assertions.assertTrue(valid);
    }

    @Test
    void multipleBracketsTest4() {
        boolean valid = validParenthesis.isValid("(({{[[]]]}))");
        Assertions.assertFalse(valid);
    }

    @Test
    void errorBracketsTest() {
        boolean valid = validParenthesis.isValid("){");
        Assertions.assertFalse(valid);
    }
}
