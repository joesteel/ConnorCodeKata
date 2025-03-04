package com.connor.leetmedium;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReverseIntegerTest {

    @Test
    void shouldReverseInt() {
        assertEquals(0, ReverseInteger.reverse(1563847412));
        assertEquals(-321, ReverseInteger.reverse(-123));
        assertEquals(-1, ReverseInteger.reverse(-1));
        assertEquals(321, ReverseInteger.reverse(123));
        assertEquals(1, ReverseInteger.reverse(1));
    }
}