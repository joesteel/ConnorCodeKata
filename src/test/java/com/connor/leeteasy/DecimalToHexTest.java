package com.connor.leeteasy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DecimalToHexTest {

    @Test
    void shouldConvert1to1() {
        assertEquals("1", DecimalToHex.toHex(1));
    }
    @Test
    void shouldConvert0to0() {
        assertEquals("0", DecimalToHex.toHex(0));
    }

    @Test
    void shouldConvert10toa() {
        assertEquals("a", DecimalToHex.toHex(10));
    }

    @Test
    void shouldConvert16to10() {
        assertEquals("10", DecimalToHex.toHex(16));
    }

    @Test
    void shouldConvert26to1a() {
        assertEquals("1a", DecimalToHex.toHex(26));
    }

    @Test
    void shouldConvertNegative1toffffffff() {
        assertEquals("ffffffff", DecimalToHex.toHex(-1));
    }
}