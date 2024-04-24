package com.connor.leeteasy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidAnagramTest {

    @Test
    void shouldReturnFalseWhenNotAnagram() {
        String s = "abc";
        String t = "abe";
        assertFalse(ValidAnagram.isAnagram(s,t));
    }

    @Test
    void shouldReturnFalseWhenNotAnagram2() {
        String s = "abc";
        String t = "abcc";
        assertFalse(ValidAnagram.isAnagram(s,t));
    }

    @Test
    void shouldReturnFalseWhenNotAnagram3() {
        String s = "abca";
        String t = "ccba";
        assertFalse(ValidAnagram.isAnagram(s,t));
    }

    @Test
    void shouldReturnTrueWhenISAnagramBoundary() {
        String s = "abz";
        String t = "zab";
        assertTrue(ValidAnagram.isAnagram(s,t));
    }

    @Test
    void shouldReturnTrueWhenISAnagramRepeatingChars() {
        String s = "abzb";
        String t = "zabb";
        assertTrue(ValidAnagram.isAnagram(s,t));
    }
}