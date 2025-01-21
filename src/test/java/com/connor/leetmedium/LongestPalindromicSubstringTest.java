package com.connor.leetmedium;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongestPalindromicSubstringTest {

    @Test
    void shouldFindLongestPal_singleCentre() {
        assertEquals("aaaaa", LongestPalindromicSubstring.longestPalindrome("aaaaaba"));
        assertEquals("cabac", LongestPalindromicSubstring.longestPalindrome("abaecabacf"));
        assertEquals("cabac", LongestPalindromicSubstring.longestPalindrome("ecabacf"));
        assertEquals("aba", LongestPalindromicSubstring.longestPalindrome("aba"));
        assertEquals("a", LongestPalindromicSubstring.longestPalindrome("ab"));
        assertEquals("a", LongestPalindromicSubstring.longestPalindrome("a"));
    }

    @Test
    void shouldFindLongestPal_doubleCentre() {
        assertEquals("aaaaaaaaaaaa", LongestPalindromicSubstring.longestPalindrome("aaaaaaaaaaaa"));
        assertEquals("cabbac", LongestPalindromicSubstring.longestPalindrome("abaecabbacf"));
        assertEquals("cabbac", LongestPalindromicSubstring.longestPalindrome("ecabbacf"));
        assertEquals("abba", LongestPalindromicSubstring.longestPalindrome("abba"));
        assertEquals("bb", LongestPalindromicSubstring.longestPalindrome("abb"));
        assertEquals("aa", LongestPalindromicSubstring.longestPalindrome("aa"));
    }
}