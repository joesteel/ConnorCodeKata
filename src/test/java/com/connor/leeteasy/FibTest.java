package com.connor.leeteasy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FibTest {

    @Test
    void shouldComputeFib() {
        assertEquals(1, Fib.fib(1));
        assertEquals(1, Fib.fib(2));
        assertEquals(2, Fib.fib(3));
        assertEquals(3, Fib.fib(4));
        assertEquals(5, Fib.fib(5));
        assertEquals(8, Fib.fib(6));
    }
}