package com.connor.leeteasy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RepeatedSubstringTest {

    @Test
    void shouldDetectNonMatchingOddLengths() {
        assertFalse(RepeatedSubstring.repeatedSubstringPattern("abc"));
        assertFalse(RepeatedSubstring.repeatedSubstringPattern("a"));

    }
    @Test
    void shouldDetectNonMatchingEvenLengths() {
        assertFalse(RepeatedSubstring.repeatedSubstringPattern("ab"));
        assertFalse(RepeatedSubstring.repeatedSubstringPattern("abcd"));
        assertFalse(RepeatedSubstring.repeatedSubstringPattern("abcabd"));
    }

    @Test
    void shouldDetectMatchingEvenLengths() {
        assertTrue(RepeatedSubstring.repeatedSubstringPattern("aa"));
        assertTrue(RepeatedSubstring.repeatedSubstringPattern("abab"));
        assertTrue(RepeatedSubstring.repeatedSubstringPattern("abababab"));
        assertTrue(RepeatedSubstring.repeatedSubstringPattern("adccadccadccadcc"));
    }

    @Test
    void shouldDetectMatchingOddLengths() {
        assertTrue(RepeatedSubstring.repeatedSubstringPattern("aaaaa"));
        assertTrue(RepeatedSubstring.repeatedSubstringPattern("abcabcabc"));
        assertTrue(RepeatedSubstring.repeatedSubstringPattern("abc abc abc "));
        assertTrue(RepeatedSubstring.repeatedSubstringPattern("abc abc abc abc abc abc abc "));

    }
}