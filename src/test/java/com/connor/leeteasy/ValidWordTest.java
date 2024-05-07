package com.connor.leeteasy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidWordTest {

    @Test
    void shouldDetectValidWord() {
        String word = "234Adas";
        assertTrue(ValidWord.isValid(word));
    }


    @Test
    void shouldDetectInvalidWord() {
        String word = "3d";
        assertFalse(ValidWord.isValid(word));
    }

    @Test
    void shouldDetectInvalidWord2() {
        String word = "234Ada:";
        assertFalse(ValidWord.isValid(word));
    }

    @Test
    void shouldDetectValidWord2() {
        String word = "AiL";
        assertTrue(ValidWord.isValid(word));
    }

    @Test
    void shouldDetectInvalidWord3() {
        String word = "UuE6";
        assertFalse(ValidWord.isValid(word));
    }

}