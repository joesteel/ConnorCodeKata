package com.connor.backtracking;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LetterCombinationTest {

    @Test
    void shouldReturnEmptyForAZeroLayerTree() {
        List<String> result = LetterCombination.letterCombination(0);
        assertTrue(result.equals(Arrays.asList("")));
    }

    @Test
    void shouldReturnEmptyForAOneLayerTree() {
        List<String> result = LetterCombination.letterCombination(1);
        assertTrue(result.equals(Arrays.asList("a", "b")));
    }

    @Test
    void shouldReturnEmptyForATwoLayerTree() {
        List<String> result = LetterCombination.letterCombination(2);
        assertTrue(result.equals(Arrays.asList("aa", "ab", "ba", "bb")));
    }

    @Test
    void shouldReturnEmptyForAThreeLayerTree() {
        List<String> result = LetterCombination.letterCombination(3);
        assertTrue(result.equals(Arrays.asList("aaa", "aab", "aba", "abb", "baa", "bab", "bba", "bbb")));
    }


}