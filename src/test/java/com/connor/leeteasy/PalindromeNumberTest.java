package com.connor.leeteasy;

import com.connor.backtracking.PalindromePartitioning;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PalindromeNumberTest {

    @Test
    void shouldReturnFalseForNonPalindromeNumber() {
        int num = 10;
        boolean result = PalindromeNumber.isPalindrome(num);
        assertFalse(result);
        result = PalindromeNumber.isPalindromeIntArray(num);
        assertFalse(result);
    }

    @Test
    void shouldReturnTrueForNonPalindromeNumberEven() {
        int num = 1001;
        boolean result = PalindromeNumber.isPalindrome(num);
        assertTrue(result);
        result = PalindromeNumber.isPalindromeIntArray(num);
        assertTrue(result);
    }


    @Test
    void shouldReturnTrueForNonPalindromeNumberOdd() {
        int num = 101;
        boolean result = PalindromeNumber.isPalindrome(num);
        assertTrue(result);
        result = PalindromeNumber.isPalindromeIntArray(num);
        assertTrue(result);
    }
}