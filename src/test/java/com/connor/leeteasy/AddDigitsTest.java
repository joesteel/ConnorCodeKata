package com.connor.leeteasy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AddDigitsTest {

    @Test
    void shouldAddDigits0() {
        assertEquals(0, AddDigits.addDigits(0));
    }

    @Test
    void shouldAddDigits10() {
        assertEquals(1, AddDigits.addDigits(10));
    }

    @Test
    void shouldAddDigits38() {
        assertEquals(2, AddDigits.addDigits(38));
    }
}