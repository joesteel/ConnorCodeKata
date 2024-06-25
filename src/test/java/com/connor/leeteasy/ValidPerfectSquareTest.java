package com.connor.leeteasy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidPerfectSquareTest {

    @Test
    void shouldFindPerfectSq() {
        assertTrue(ValidPerfectSquare.isPerfectSquare(1));
        assertTrue(ValidPerfectSquare.isPerfectSquare(4));
        assertTrue(ValidPerfectSquare.isPerfectSquare(9));
        assertTrue(ValidPerfectSquare.isPerfectSquare(16));
    }

    @Test
    void shouldNotFindPerfectSq() {
        assertFalse(ValidPerfectSquare.isPerfectSquare(0));
        assertFalse(ValidPerfectSquare.isPerfectSquare(10));
        assertFalse(ValidPerfectSquare.isPerfectSquare(5));
        assertFalse(ValidPerfectSquare.isPerfectSquare(30));
    }

    @Test
    void shouldDealWithOutOfBounds() {
        assertFalse(ValidPerfectSquare.isPerfectSquare(2147483647));
    }
}