package com.connor.dynamicprogramming;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PerfectSquareTest {
    @Test
    void shouldReturnOneForOne() {
        int n = 1;
        int result = PerfectSquare.perfectSquares(n);
        assertEquals(1, result);
    }

    @Test
    void shouldReturnTwoForTwo() {
        int n = 2;
        int result = PerfectSquare.perfectSquares(n);
        assertEquals(2, result);
    }


    @Test
    void shouldReturnOneForFour() {
        int n = 4;
        int result = PerfectSquare.perfectSquares(n);
        assertEquals(1, result);
    }

    @Test
    void shouldReturnTwoForFive() {
        int n = 5;
        int result = PerfectSquare.perfectSquares(n);
        assertEquals(2, result);
    }

    @Test
    void shouldReturnThreeForTwelve() {
        int n = 12;
        int result = PerfectSquare.perfectSquares(n);
        assertEquals(3, result);
    }


    @Test
    void shouldReturnTwoForThirteen() {
        int n = 13;
        int result = PerfectSquare.perfectSquares(n);
        assertEquals(2, result);
    }

}