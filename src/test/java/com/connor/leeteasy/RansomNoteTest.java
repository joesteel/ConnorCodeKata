package com.connor.leeteasy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RansomNoteTest {

    @Test
    void shouldReturnTrue() {
        boolean result = RansomNote.canConstruct("a", "a");
        assertTrue(result);
        result = RansomNote.canConstruct("a", "aa");
        assertTrue(result);
        result = RansomNote.canConstruct("a", "ab");
        assertTrue(result);
        result = RansomNote.canConstruct("baa", "aba");
        assertTrue(result);
    }

    @Test
    void shouldReturnFalse() {
        boolean result = RansomNote.canConstruct("ab", "b");
        assertFalse(result);
        result = RansomNote.canConstruct("abc", "ab");
        assertFalse(result);
    }
}