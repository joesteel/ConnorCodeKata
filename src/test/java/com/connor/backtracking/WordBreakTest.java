package com.connor.backtracking;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WordBreakTest {

    @Test
    void shouldDetectTrueFromOneWord() {
        String t = "aaa";
        List<String> words = Arrays.asList("a");
        boolean result = WordBreak.wordBreak(t, words);
        assertTrue(result);
    }

    @Test
    void shouldDetectFalseFromOneWord() {
        String t = "aac";
        List<String> words = Arrays.asList("a");
        boolean result = WordBreak.wordBreak(t, words);
        assertFalse(result);
    }


    @Test
    void shouldDetectFalseFromTwoWords() {
        String t = "aac";
        List<String> words = Arrays.asList("a", "c");
        boolean result = WordBreak.wordBreak(t, words);
        assertTrue(result);
    }

    @Test
    void shouldDetectFalseFromTwoMultilineWords() {
        String t = "algomonster";
        List<String> words = Arrays.asList("algo", "monster");
        boolean result = WordBreak.wordBreak(t, words);
        assertTrue(result);
    }

    @Test
    void shouldDetectFalseFromOneWord_fast() {
        String t = "aac";
        List<String> words = Arrays.asList("a");
        boolean result = WordBreak.wordBreak(t, words, "fast");
        assertFalse(result);
    }


    @Test
    void shouldDetectFalseFromTwoWords_fast() {
        String t = "aac";
        List<String> words = Arrays.asList("aa", "c");
        boolean result = WordBreak.wordBreak(t, words, "fast");
        assertTrue(result);
    }

    @Test
    void shouldDetectFalseFromTwoMultilineWords_fast() {
        String t = "algomonster";
        List<String> words = Arrays.asList("algo", "monster");
        boolean result = WordBreak.wordBreak(t, words, "fast");
        assertTrue(result);
    }

    @Test
    void shouldDetectTrueFromTwoMultilineWords_memo() {
        String t = "algomonster";
        List<String> words = Arrays.asList("algo", "monster");
        boolean result = WordBreak.wordBreak(t, words, "memo");
        assertTrue(result);
    }

    @Test
    void shouldDetectTrueFromTwoWords_memo() {
        String t = "aac";
        List<String> words = Arrays.asList("aa", "c");
        boolean result = WordBreak.wordBreak(t, words, "memo");
        assertTrue(result);
    }

    @Test
    void shouldDetectFalseFromTwoWords_memo() {
        String t = "aacb";
        List<String> words = Arrays.asList("aa", "c");
        boolean result = WordBreak.wordBreak(t, words, "memo");
        assertFalse(result);
    }

}