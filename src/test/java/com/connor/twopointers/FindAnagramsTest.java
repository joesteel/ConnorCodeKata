package com.connor.twopointers;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FindAnagramsTest {

    @Test
    void shouldFindAnagramsSimple() {
        String original = "cba", check = "abc";
        List<Integer> result = FindAnagrams.findAllAnagrams(original, check);
        assertTrue(result.equals(Arrays.asList(0)));
    }

    @Test
    void shouldNoFindAnagramsWhenEmptyOriginal() {
        String original = "", check = "abc";
        List<Integer> result = FindAnagrams.findAllAnagrams(original, check);
        assertTrue(result.equals(Arrays.asList()));
    }

    @Test
    void shouldNoFindAnagramsWhenOriginalSmallerThanCheck() {
        String original = "ab", check = "abc";
        List<Integer> result = FindAnagrams.findAllAnagrams(original, check);
        assertTrue(result.equals(Arrays.asList()));
    }

    @Test
    void shouldNoFindAnagramsWhenTwoAnagramsWithin() {
        String original = "abca", check = "abc";
        List<Integer> result = FindAnagrams.findAllAnagrams(original, check);
        assertTrue(result.equals(Arrays.asList(0,1)));
    }

    @Test
    void shouldNoFindAnagramsWhenThreeAnagramsWithin() {
        String original = "abcadbaefcba", check = "abc";
        List<Integer> result = FindAnagrams.findAllAnagrams(original, check);
        assertTrue(result.equals(Arrays.asList(0,1,9)));
    }

}