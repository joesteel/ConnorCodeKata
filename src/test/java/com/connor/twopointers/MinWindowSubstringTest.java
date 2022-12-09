package com.connor.twopointers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinWindowSubstringTest {


    @Test
    void shouldCorrectlyDetectThatCheckIsPresentInString() {
        String string = "abcoiasuroijfasdlkjgaosdj";
        String check = "bac";
        int[] encodedCheck = new int[150];
        for(int i = 0; i<check.length(); i++){
            encodedCheck[check.charAt(i)-'A']++;
        }
        boolean result = MinWindowSubstring.stringContainsCheck(string, encodedCheck);
        assertTrue(result);
    }

    @Test
    void shouldCorrectlyDetectThatCheckIsNoPresentInString() {
        String string = "abc";
        String check = "baca";
        int[] encodedCheck = new int[150];
        for(int i = 0; i<check.length(); i++){
            encodedCheck[check.charAt(i)-'A']++;
        }
        boolean result = MinWindowSubstring.stringContainsCheck(string, encodedCheck);
        assertFalse(result);
    }


    @Test
    void shouldReturnEmptyWhenNoMatchingSubStr() {
        String original = "ab", check = "abc";
        String result = MinWindowSubstring.getMinimumWindow(original, check);
        assertTrue(result.equals(""));
    }

    @Test
    void shouldReturnResultWhenOneMatchingSubStrWhereOriginalIsSameSizeAsCheck() {
        String original = "bac", check = "abc";
        String result = MinWindowSubstring.getMinimumWindow(original, check);
        assertTrue(result.equals("bac"));
    }

    @Test
    void shouldReturnResultWhenOneMatchingSubStr() {
        String original = "zbacz", check = "abc";
        String result = MinWindowSubstring.getMinimumWindow(original, check);
        assertTrue(result.equals("bac"));
    }

    @Test
    void shouldReturnResultWhenMatchingSubStr() {
        String original = "zbasczcba", check = "abc";
        String result = MinWindowSubstring.getMinimumWindow(original, check);
        assertTrue(result.equals("cba"));
    }

    @Test
    void shouldReturnResultWhenMatchingSubStrIsLargerThanCheck() {
        String original = "cdbaebaecd", check = "abc";
        String result = MinWindowSubstring.getMinimumWindow(original, check);
        assertTrue(result.equals("baec"));
    }

    @Test
    void shouldReturnSmallestLexicographicallyWhenOneSubStrMatchesTwice() {
        String original = "zbacabc", check = "abc";
        String result = MinWindowSubstring.getMinimumWindow(original, check);
        assertTrue(result.equals("abc"));
    }
}