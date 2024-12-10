package com.connor.leeteasy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DetectCapitalTest {

    @Test
    void shouldDetectValidCapital() {
        assertTrue(DetectCapital.detectCapitalUse("USA"));
        assertTrue(DetectCapital.detectCapitalUse("usa"));
        assertTrue(DetectCapital.detectCapitalUse("Usa"));
        assertTrue(DetectCapital.detectCapitalUse("U"));
        assertTrue(DetectCapital.detectCapitalUse("u"));
    }

    @Test
    void shouldDetectInValidCapital() {
        assertFalse(DetectCapital.detectCapitalUse("USAa"));
        assertFalse(DetectCapital.detectCapitalUse("UsaaA"));
        assertFalse(DetectCapital.detectCapitalUse("ssaaA"));
    }
}