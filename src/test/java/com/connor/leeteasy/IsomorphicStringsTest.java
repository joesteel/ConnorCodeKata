package com.connor.leeteasy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IsomorphicStringsTest {

    @Test
    void shouldDetectIsoString() {
        String s = "ass";
        String t = "tpp";
        boolean result = IsomorphicStrings.isIsomorphic(s,t);
        assertTrue(result);
    }

    @Test
    void shouldDetectIsoString2() {
        String s = "paper";
        String t = "title";
        boolean result = IsomorphicStrings.isIsomorphic(s,t);
        assertTrue(result);
    }

    @Test
    void shouldDetectNonIsoString() {
        String s = "ass";
        String t = "tpe";
        boolean result = IsomorphicStrings.isIsomorphic(s,t);
        assertFalse(result);
    }

    @Test
    void shouldDetectNonIsoString_2() {
        String s = "badc";
        String t = "baba";
        boolean result = IsomorphicStrings.isIsomorphic(s,t);
        assertFalse(result);
    }
}