package com.connor.leeteasy;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FizzBuzzTest {

    @Test
    void shouldGetCorrectSequenceForFirst5() {
        List<String> result = FizzBuzz.fizzBuzz(5);
        assertEquals(result.get(0), "1");
        assertEquals(result.get(1), "2");
        assertEquals(result.get(2), "Fizz");
        assertEquals(result.get(3), "4");
        assertEquals(result.get(4), "Buzz");
    }

    @Test
    void shouldGetCorrectSequenceForFirst15() {
        List<String> result = FizzBuzz.fizzBuzz(15);
        assertEquals(result.get(0), "1");
        assertEquals(result.get(1), "2");
        assertEquals(result.get(2), "Fizz");
        assertEquals(result.get(3), "4");
        assertEquals(result.get(4), "Buzz");
        assertEquals(result.get(5), "Fizz");
        assertEquals(result.get(8), "Fizz");
        assertEquals(result.get(9), "Buzz");
        assertEquals(result.get(10), "11");
        assertEquals(result.get(14), "FizzBuzz");

    }
}