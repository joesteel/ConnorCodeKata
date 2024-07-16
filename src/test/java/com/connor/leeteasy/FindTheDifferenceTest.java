package com.connor.leeteasy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FindTheDifferenceTest {

    @Test
    void shouldFindTheDifference() {
        char result = FindTheDifference.findTheDifference("abcd", "abecd");
        assertEquals('e', result);
    }

    @Test
    void shouldFindTheDifference_dup() {
        char result = FindTheDifference.findTheDifference("a", "aa");
        assertEquals('a', result);
    }
}