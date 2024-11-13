package com.connor.leeteasy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Base7Test {

    @Test
    void shouldCalcBase7Positive() {
        assertEquals("10", Base7.convertToBase7(7));
        assertEquals("11", Base7.convertToBase7(8));
        assertEquals("1", Base7.convertToBase7(1));
        assertEquals("0", Base7.convertToBase7(0));
        assertEquals("10", Base7.convertBase7Recursive(7));
        assertEquals("11", Base7.convertBase7Recursive(8));
        assertEquals("1", Base7.convertBase7Recursive(1));
        assertEquals("0", Base7.convertBase7Recursive(0));
    }

    @Test
    void shouldCalcBase7Negative() {
        assertEquals("-10", Base7.convertToBase7(-7));
        assertEquals("-11", Base7.convertToBase7(-8));
        assertEquals("-1", Base7.convertToBase7(-1));
        assertEquals("-10", Base7.convertBase7Recursive(-7));
        assertEquals("-11", Base7.convertBase7Recursive(-8));
        assertEquals("-1", Base7.convertBase7Recursive(-1));
    }
}