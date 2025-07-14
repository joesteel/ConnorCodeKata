package com.connor.leetmedium;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IntToRomanTest {

    @Test
    void shouldReturnSimpleRomanNumeral() {
        assertEquals("MMMDCCXLIX", IntToRoman.intToRoman(3749));
        assertEquals("MCMXCIV", IntToRoman.intToRoman(1994));
        assertEquals("XCI", IntToRoman.intToRoman(91));
        assertEquals("XXII", IntToRoman.intToRoman(22));
        assertEquals("X", IntToRoman.intToRoman(10));
        assertEquals("IX", IntToRoman.intToRoman(9));
        assertEquals("VI", IntToRoman.intToRoman(6));
        assertEquals("V", IntToRoman.intToRoman(5));
        assertEquals("IV", IntToRoman.intToRoman(4));
        assertEquals("III", IntToRoman.intToRoman(3));
        assertEquals("II", IntToRoman.intToRoman(2));
        assertEquals("I", IntToRoman.intToRoman(1));
    }
}