package com.connor.leeteasy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidPalindromeTest {

    @Test
    void shouldReturnTrueForSWithSpecials() {
        assertTrue(ValidPalindrome.isPalindrome("A man, a plan, a canal: Panama"));
    }


    @Test
    void shouldReturnFalseForSimple() {
        assertFalse(ValidPalindrome.isPalindrome("race a car"));
    }

    @Test
    void shouldStripNumbers() {
        assertFalse(ValidPalindrome.isPalindrome("0P"));
    }


}