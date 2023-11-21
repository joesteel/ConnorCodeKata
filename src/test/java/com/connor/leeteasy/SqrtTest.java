package com.connor.leeteasy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SqrtTest {

    @Test
    void shouldReturn4When16() {
        assertEquals(4, Sqrt.mySqrt(16));
    }

    @Test
    void shouldReturn1When1() {
        assertEquals(1, Sqrt.mySqrt(1));
    }

    @Test
    void shouldReturn1When3() {
        assertEquals(1, Sqrt.mySqrt(3));
    }

    @Test
    void shouldReturn12When144() {
        assertEquals(12, Sqrt.mySqrt(144));
    }

    @Test
    void shouldReturn2When8() {
        assertEquals(2, Sqrt.mySqrt(8));
    }


    @Test
    void shouldReturn46339When2147395599() {
        assertEquals(46339, Sqrt.mySqrt(2147395599));
    }

}