package com.connor.priorityq;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReorganizeStringTest {

    @Test
    void shouldReturnEmptyForInvalidPattern() {
        String s = "aaaaa";
        String result = ReorganizeString.reorganizeString(s);
        assertTrue(result.equals(""));
    }

    @Test
    void shouldReturnEmptyForInvalidPattern2() {
        String s = "";
        String result = ReorganizeString.reorganizeString(s);
        assertTrue(result.equals(""));
    }

    @Test
    void shouldReturnEmptyForInvalidPattern3() {
        String s = "baaaa";
        String result = ReorganizeString.reorganizeString(s);
        assertTrue(result.equals(""));
    }

    @Test
    void shouldReturnEmptyForValidPattern() {
        String s = "baa";
        String result = ReorganizeString.reorganizeString(s);
        assertTrue(result.equals("aba"));
    }

    @Test
    void shouldReturnEmptyForValidPattern2() {
        String s = "bbaa";
        String result = ReorganizeString.reorganizeString(s);
        assertTrue(result.equals("abab"));
    }

}