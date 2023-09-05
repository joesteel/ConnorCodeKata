package com.connor.leeteasy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IndexOfFirstOccurrenceTest {
    @Test
    void shouldFindFirstOccurrenceSimple() {
        String haystack = "hello connor hello";
        String needle = "hello";
        int result = IndexOfFirstOccurrence.strStr(haystack, needle);
        assertEquals(0, result);
    }

    @Test
    void shouldFindNoOccurrenceSimple() {
        String haystack = "helo connor helo";
        String needle = "hello";
        int result = IndexOfFirstOccurrence.strStr(haystack, needle);
        assertEquals(-1, result);
    }

    @Test
    void shouldFindFirstOccurrenceComplex() {
        String haystack = "0123456789hello";
        String needle = "hello";
        int result = IndexOfFirstOccurrence.strStr(haystack, needle);
        assertEquals(10, result);
    }

    @Test
    void shouldFindNoOccurrenceBoundaryTest() {
        String haystack = "0123456789hell";
        String needle = "hello";
        int result = IndexOfFirstOccurrence.strStr(haystack, needle);
        assertEquals(-1, result);
    }

}