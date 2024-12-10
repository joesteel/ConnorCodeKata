package com.connor.leeteasy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongestUncommonSubsequenceTest {

    @Test
    void shouldDetectLongestUncommon_InputsDifferentLength() {
        assertEquals(4, LongestUncommonSubsequence.findLUSlength("abca", "bcd"));
    }

    @Test
    void shouldDetectLongestUncommon_theSameStrings() {
        assertEquals(-1, LongestUncommonSubsequence.findLUSlength("aaa", "aaa"));
    }

    @Test
    void shouldDetectLongestUncommon_theSameLength() {
        assertEquals(3, LongestUncommonSubsequence.findLUSlength("aaa", "aac"));
    }
}