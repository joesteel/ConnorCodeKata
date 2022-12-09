package com.connor.twopointers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidPalindromeTest {

    @Test
    void shouldReturnTrueForOddPalindrome() {
        assertTrue(ValidPalindrome.isPalindrome("aba"));
        assertTrue(ValidPalindrome.isPalindrome2("a b a"));

    }
}