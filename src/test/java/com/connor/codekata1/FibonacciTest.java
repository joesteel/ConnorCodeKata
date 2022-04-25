package com.connor.codekata1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FibonacciTest {

    @Test
    void shouldCalculateResultForFirstTwoNumbers() {
        int expectedResult = 1;
        Fibonacci f = new Fibonacci();
        int actualResult = f.calculateFib(2)[0];
        assert(expectedResult == actualResult);
    }

    @Test
    void shouldCalculateResultForFirstSixNumbers() {
        int expectedResult = 5 ; // 0 1 1 2 3 5
        Fibonacci f = new Fibonacci();
        int actualResult = f.calculateFib(6)[0];
        assert(expectedResult == actualResult);
    }

    @Test
    void shouldCalculateResultForFirstTwentyNumbers() {
        int expectedResult = 4181 ; // starting from 0
        Fibonacci f = new Fibonacci();
        int actualResult = f.calculateFib(20)[0];
        assert(expectedResult == actualResult);
    }


}