package com.connor.leeteasy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RomanToIntegerTest {

    @Test
    void shouldReturn0ForEmptyString() {
        int result = RomanToInteger.romanToInt("");
        assertEquals(0, result);
    }

    @Test
    void shouldReturn1Fori() {
        int result = RomanToInteger.romanToInt("i");
        assertEquals(1, result);
    }

    @Test
    void shouldReturn3Foriii() {
        int result = RomanToInteger.romanToInt("iii");
        assertEquals(3, result);
    }

    @Test
    void shouldReturn4Foriv() {
        int result = RomanToInteger.romanToInt("iv");
        assertEquals(4, result);
    }

    @Test
    void shouldReturn909Forcmix() {
        int result = RomanToInteger.romanToInt("cmix");
        assertEquals(909, result);
    }

    @Test
    void shouldReturn1994ForMCMXCIV() {
        int result = RomanToInteger.romanToInt("MCMXCIV");
        assertEquals(1994, result);
    }

}