package com.connor.leeteasy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KeyboardRowTest {

    @Test
    void shouldReturnNoMatches() {
        String[] result = KeyboardRow.findWords(new String[]{"wedc", "ascv"});
        assertEquals(0, result.length);
    }

    @Test
    void shouldReturnMultipleRowMatches() {
        String[] result = KeyboardRow.findWords(new String[]{"wedc", "ascv", "rtyui", "asdf", "zxcv"});
        assertEquals(3, result.length);
        assertArrayEquals(new String[]{"rtyui", "asdf", "zxcv"}, result);
    }
}