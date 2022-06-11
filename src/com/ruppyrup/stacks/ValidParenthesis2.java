package com.ruppyrup.stacks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Deque;
import java.util.LinkedList;

public class ValidParenthesis2 {

    public boolean isValid(String s) {
        if (s.length() <= 1) return false;
        Deque<Character> brackets = new LinkedList<>();
        return solve(s, brackets);
    }

    private boolean solve(String s, Deque<Character> brackets) {
        if (s.isEmpty() && brackets.isEmpty()) return true;
        if (s.isEmpty() && !brackets.isEmpty()) return false;

        char bracket = s.charAt(0);

        if (bracket == '(' || bracket == '[' || bracket == '{') {
            brackets.push(bracket);
            return solve(s.substring(1), brackets);
        } else {
            if (brackets.isEmpty()) return false;
            char pop = brackets.pop();
            if (pop == swapreverse(bracket)) {
                return solve(s.substring(1), brackets);
            }
        }
        return false;
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


class ValidParenthesis2Test {

    private ValidParenthesis2 validParenthesis = new ValidParenthesis2();

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
