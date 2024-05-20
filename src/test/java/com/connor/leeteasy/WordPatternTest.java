package com.connor.leeteasy;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class WordPatternTest {

    @Test
    void shouldDetectNonRepeatingMatch() {
        String pattern  = "ab";
        String string = "Dog Cat";
        boolean result = WordPattern.wordPattern(pattern, string);
        assertTrue(result);
    }

    @Test
    void shouldDetectRepeatingMatch() {
        String pattern  = "aba";
        String string = "Dog Cat Dog";
        boolean result = WordPattern.wordPattern(pattern, string);
        assertTrue(result);
    }

    @Test
    void shouldDetectRepeatingMatch_2() {
        String pattern  = "abba";
        String string = "Dog Cat Cat Dog";
        boolean result = WordPattern.wordPattern(pattern, string);
        assertTrue(result);
    }

    @Test
    void shouldDetectRepeatingMatch_3() {
        String pattern  = "e";
        String string = "Dogooo";
        boolean result = WordPattern.wordPattern(pattern, string);
        assertTrue(result);
    }

    @Test
    void shouldDetectRepeatingMatch_4() {
        String pattern  = "efghie";
        String string = "e f g h i e";
        boolean result = WordPattern.wordPattern(pattern, string);
        assertTrue(result);
    }


    @Test
    void shouldDetectNonRepeatingFail() {
        String pattern  = "abc";
        String string = "Dog Cat Dog";
        boolean result = WordPattern.wordPattern(pattern, string);
        assertFalse(result);
    }



}