package com.connor.backtracking;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class PhoneNumberTest {

    @Test
    void shouldMapDigitsToLettersCorrectly() {
        assertEquals("abc", PhoneNumber.digitsToLetters(2));
        assertEquals("def", PhoneNumber.digitsToLetters(3));
        assertEquals("ghi", PhoneNumber.digitsToLetters(4));
        assertEquals("jkl", PhoneNumber.digitsToLetters(5));
        assertEquals("mno", PhoneNumber.digitsToLetters(6));
        assertEquals("pqrs", PhoneNumber.digitsToLetters(7));
        assertEquals("tuv", PhoneNumber.digitsToLetters(8));
        assertEquals("wxyz", PhoneNumber.digitsToLetters(9));
    }


    @Test
    void shouldReturnCorrectLetterComboForTwoDigitPhoneNumber() {
        String digits = "23";
        assertTrue(PhoneNumber.letterCombinationsOfPhoneNumber(digits).equals(Arrays.asList("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf")));
    }
}