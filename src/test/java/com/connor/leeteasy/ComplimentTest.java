package com.connor.leeteasy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ComplimentTest {
    @Test
    void shouldFlipBits() {
        assertEquals(2, Compliment.findComplement(5));
        assertEquals(0, Compliment.findComplement(3));
        assertEquals(0, Compliment.findComplement(1));
        assertEquals(7, Compliment.findComplement(8));
    }
}