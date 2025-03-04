package com.connor.leetmedium;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ZIGZAGTest {


    @Test
    void shouldPerformSimpleZigZagConversion_0() {
        /*
        0 2 4
        1 3 5


        024135
        */
        String result = ZIGZAG.convert("012345", 2);
        assertEquals("024135", result);
    }
    @Test
    void shouldPerformSimpleZigZagConversion_1() {
        /*
        0   4
        1 3 5
        2   6

        0413526
        */
        String result = ZIGZAG.convert("0123456", 3);
        assertEquals("0413526", result);
    }

    @Test
    void shouldPerformSimpleZigZagConversion_2() {
        /*
        0     6
        1   5 7
        2 4   8 a
        3     9

        06157248a39
        */
        String result = ZIGZAG.convert("0123456789a", 4);
        assertEquals("06157248a39", result);
    }

    @Test
    void shouldPerformSimpleZigZagConversion_3() {
        assertEquals("PINALSIGYAHRPI", ZIGZAG.convert("PAYPALISHIRING", 4));
        assertEquals("PAHNAPLSIIGYIR", ZIGZAG.convert("PAYPALISHIRING", 3));
    }

    @Test
    void shouldPerformSimpleZigZagConversion_4() {
        assertEquals("A", ZIGZAG.convert("A", 1));
    }
}