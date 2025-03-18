package com.connor.leetmedium;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringToIntAtoiTest {

    @Test
    void shouldConvertStringToNum_HappyPath() {
        assertEquals(-100, StringToIntAtoi.myAtoi("-100"));
        assertEquals(100100, StringToIntAtoi.myAtoi("100100"));
        assertEquals(100, StringToIntAtoi.myAtoi("100"));
        assertEquals(1, StringToIntAtoi.myAtoi("1"));
    }
    @Test
    void shouldConvertStringToNum_MinInt() {
        assertEquals(Integer.MIN_VALUE, StringToIntAtoi.myAtoi("-2147483648"));
        assertEquals(Integer.MIN_VALUE, StringToIntAtoi.myAtoi("-2147483649"));
    }
    @Test
    void shouldConvertStringToNum_MaxInt() {
        assertEquals(Integer.MAX_VALUE, StringToIntAtoi.myAtoi("2147483647"));
        assertEquals(Integer.MAX_VALUE, StringToIntAtoi.myAtoi("2147483648"));
    }
    @Test
    void shouldConvertStringToNum_CombinationsOfSadness() {
        assertEquals(100, StringToIntAtoi.myAtoi("   0100asdf"));
    }
    @Test
    void shouldConvertStringToNum_TrailingGarbage() {
        assertEquals(100, StringToIntAtoi.myAtoi("100adsf12"));
    }
    @Test
    void shouldConvertStringToNum_LeadingZeros() {
        assertEquals(-100, StringToIntAtoi.myAtoi("-0100"));
        assertEquals(100, StringToIntAtoi.myAtoi("00100"));
    }
    @Test
    void shouldConvertStringToNum_LeadingWhiteSpace() {
        assertEquals(100, StringToIntAtoi.myAtoi("   100"));
    }
}