package com.connor.leeteasy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LengthOfLastWordTest {

    @Test
    void shouldReturnLengthOfLastWordWhenOneWord() {
        String word = "word";
        int result = LengthOfLastWord.lengthOfLastWord(word);
        assertEquals(4, result);
    }

    @Test
    void shouldReturnLengthOfLastWordWhenMultipleWords() {
        String word = "word word";
        int result = LengthOfLastWord.lengthOfLastWord(word);
        assertEquals(4, result);
    }

    @Test
    void shouldReturnLengthOfLastWordWhenMultipleWordsAndTrailingWhiteSpace() {
        String word = "word word   ";
        int result = LengthOfLastWord.lengthOfLastWord(word);
        assertEquals(4, result);
    }

    @Test
    void shouldReturnLengthOfLastWordWhenOneWordTrailingAndLeadingWhiteSpace() {
        String word = " word ";
        int result = LengthOfLastWord.lengthOfLastWord(word);
        assertEquals(4, result);
    }
}