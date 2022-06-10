package com.ruppyrup.misc;

import java.util.Arrays;
import java.util.stream.IntStream;

public class FlippingBits {

    public static void main(String[] args) {
        System.out.println(flippingBits(4L));
    }

    static long flippingBits(long n) {
        String bits = Long.toBinaryString(n);
        String bitsWithPadding = padBits(bits);
        String invertedBits = invertBits(bitsWithPadding);
        return Long.parseUnsignedLong(invertedBits, 2);

    }

    private static String padBits(String bits) {
        int padding = 32 - bits.length();
        StringBuilder stringBuilder = new StringBuilder();
        IntStream.range(0, padding)
                .mapToObj(i -> "0")
                .forEach(stringBuilder::append);
        return stringBuilder.append(bits).toString();
    }

    private static String invertBits(String bits) {
        String[] bitArray = bits.split("");
        StringBuilder stringBuilder = new StringBuilder();
        Arrays.stream(bitArray)
                .map(bit -> bit.equals("0") ? "1" : "0")
                .forEach(stringBuilder::append);
        return stringBuilder.toString();
    }
}
