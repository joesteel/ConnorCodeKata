package com.connor.backtracking;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.List;

class PermutationsTest {

    @Test
    void shouldCoverAllPermutationsForLetterSizeOne() {
        String letters = "a";
        List<String> result = Permutations.permutations(letters);
        assertTrue(Arrays.asList("a").equals(result));
    }

    @Test
    void shouldCoverAllPermutationsForLetterSizeTwo() {
        String letters = "ab";
        List<String> result = Permutations.permutations(letters);
        assertTrue(Arrays.asList("ab", "ba").equals(result));
    }

    @Test
    void shouldCoverAllPermutationsForLetterSizeThree() {
        String letters = "abc";
        List<String> result = Permutations.permutations(letters);
        assertTrue(Arrays.asList("abc", "acb", "bac", "bca", "cab", "cba").equals(result));
    }

}