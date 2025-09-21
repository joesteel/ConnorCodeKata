package com.connor.leeteasy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidPalindromeIITest {

    @Test
    void shouldDetectValidPalindrome() {
        assertTrue(ValidPalindromeII.validPalindrome("cbc"));
        assertTrue(ValidPalindromeII.validPalindrome("abba"));
        assertTrue(ValidPalindromeII.validPalindrome("a"));
    }


        @Test
    void shouldDetectValidPalindromeAfterOneSkip() {
        assertTrue(ValidPalindromeII.validPalindrome("ccbbbccc"));
        assertTrue(ValidPalindromeII.validPalindrome("cbbcc"));
        assertTrue(ValidPalindromeII.validPalindrome("abca"));
        assertTrue(ValidPalindromeII.validPalindrome("deeee"));
    }

    @Test
    void shouldDetectInValidPalindrome() {
        assertFalse(ValidPalindromeII.validPalindrome("abc"));
        assertFalse(ValidPalindromeII.validPalindrome("fcbce"));
        assertFalse(ValidPalindromeII.validPalindrome("asadfa"));
        assertFalse(ValidPalindromeII.validPalindrome("efegh"));
    }
}