package com.connor.twopointers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongestSubstringTest {


    @Test
    void shouldReturn0ForEmptyString() {
        assertEquals(0, LongestSubstring.longestSubstringWithoutRepeatingCharacters(""));
    }

    @Test
    void shouldReturn1ForStringOfSize1() {
        assertEquals(1, LongestSubstring.longestSubstringWithoutRepeatingCharacters("a"));
    }


    @Test
    void shouldReturn1ForStringOfSize2WithRepeatingChars() {
        assertEquals(1, LongestSubstring.longestSubstringWithoutRepeatingCharacters("aa"));
    }

    @Test
    void shouldReturn1ForStringOfSize3WithNoRepeatingChars() {
        assertEquals(3, LongestSubstring.longestSubstringWithoutRepeatingCharacters("abc"));
    }

    @Test
    void shouldReturn1ForStringOfSize4WithRepeatingChars() {
        assertEquals(2, LongestSubstring.longestSubstringWithoutRepeatingCharacters("abbc"));
    }

    @Test
    void shouldReturn1ForStringOfSize8WithRepeatingChars() {
        assertEquals(4, LongestSubstring.longestSubstringWithoutRepeatingCharacters("abcdabcd"));
    }
}