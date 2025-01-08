package com.connor.leeteasy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReverseStringIITest {

    @Test
    void shouldReverseSimple() {
        String s = "abcdefg";
        int k = 2;
        String result = ReverseStringII.reverseStr(s, k);
        assertEquals( "bacdfeg", result);
    }

    @Test
    void shouldReverseSimple_Even() {
        String s = "abcdef";
        int k = 3;
        String result = ReverseStringII.reverseStr(s, k);
        assertEquals( "cbadef", result);
    }

    @Test
    void shouldReverseSimple_OutOfBounds() {
        String s = "abc";
        int k = 4;
        String result = ReverseStringII.reverseStr(s, k);
        assertEquals( "cba", result);
    }
}