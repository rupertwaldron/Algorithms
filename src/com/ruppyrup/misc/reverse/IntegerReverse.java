package com.ruppyrup.misc.reverse;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class IntegerReverse {

    public int reverse(int input) {
        int reversed = 0;
        int remainder = 0;
        while (input > 0) {
            remainder = input % 10;
            input /= 10;
            reversed = reversed * 10 + remainder;
        }
        return reversed;
    }
}

class IntegerReverseTest {

    private IntegerReverse integerRev;


    @BeforeEach
    void setUp() {
        integerRev = new IntegerReverse();
    }

    @Test
    void testOneInt() {
        int input = 1;
        int result = integerRev.reverse(input);
        Assertions.assertEquals(input, result);
    }


    @Test
    void testTwoInt() {
        int input = 12;
        int result = integerRev.reverse(input);
        Assertions.assertEquals(21, result);
    }

    @Test
    void testThreeInt() {
        int input = 123;
        int result = integerRev.reverse(input);
        Assertions.assertEquals(321, result);
    }

}


