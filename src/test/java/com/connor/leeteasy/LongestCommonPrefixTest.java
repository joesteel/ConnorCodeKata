package com.connor.leeteasy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongestCommonPrefixTest {

    @Test
    void shouldReturnLengthOfFirstElementIfOnlyOneString() {
        String[] strs = new String[1];
        strs[0] = "hello";
        String result = LongestCommonPrefix.longestCommonPrefix(strs);
        assertEquals("hello", result);
    }

    @Test
    void shouldReturnEmptyStringIfNoCommonPrefix() {
        String[] strs = {"home", "phone"};
        String result = LongestCommonPrefix.longestCommonPrefix(strs);
        assertEquals("", result);
    }


    @Test
    void shouldReturnCommonPrefix_1() {
        String[] strs = {"home", "hope", "ho", "homer"};
        String result = LongestCommonPrefix.longestCommonPrefix(strs);
        assertEquals("ho", result);
    }

    @Test
    void shouldReturnCommonPrefix_2() {
        String[] strs = {"flower","flow","flight"};
        String result = LongestCommonPrefix.longestCommonPrefix(strs);
        assertEquals("fl", result);
    }

    @Test
    void shouldReturnCommonPrefix_LastElementNoCommon() {
        String[] strs = {"flower","flow","flight", "flower","flow","flight", "flower","flow","flight", "flower","flow",""};
        String result = LongestCommonPrefix.longestCommonPrefix(strs);
        assertEquals("", result);
    }

}