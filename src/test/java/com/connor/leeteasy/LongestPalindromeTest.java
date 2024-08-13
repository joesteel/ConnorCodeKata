package com.connor.leeteasy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongestPalindromeTest {

    @Test
    void shouldReturn0WhenEmpty() {
        int result = LongestPalindrome.longestPalindrome("");
        assertEquals(0, result);
    }

    @Test
    void shouldReturn1When1Chars() {
        int result = LongestPalindrome.longestPalindrome("a");
        assertEquals(1, result);
    }

    @Test
    void shouldReturn1When2Individuals() {
        int result = LongestPalindrome.longestPalindrome("za");
        assertEquals(1, result);
    }

    @Test
    void shouldReturn2When2MatchingChars() {
        int result = LongestPalindrome.longestPalindrome("aa");
        assertEquals(2, result);
    }

    @Test
    void shouldReturn4When2PairsOfMatchingCharsWithUpperCase() {
        int result = LongestPalindrome.longestPalindrome("AaaA");
        assertEquals(4, result);
    }

    @Test
    void shouldReturnOddNumberWhenMulPairsOfMatchingCharsWithMultipleAdditionalIndividuals() {
        int result = LongestPalindrome.longestPalindrome("bceAaaA");
        assertEquals(5, result);
    }
}