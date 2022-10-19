package com.connor.backtracking;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PalindromePartitioningTest {

    @Test
    void shouldDetectPalindrome() {
        String Palindrome = "abba";
        assertTrue(PalindromePartitioning.isPalindrome(Palindrome));
        String Palindrome2 = "aba";
        assertTrue(PalindromePartitioning.isPalindrome(Palindrome));
        String Palindrome3 = "rotator";
        assertTrue(PalindromePartitioning.isPalindrome(Palindrome));
    }

    @Test
    void shouldRejectNonPalindrome() {
        String notPalindrome = "abcd";
        assertEquals(false, PalindromePartitioning.isPalindrome(notPalindrome));
    }

    @Test
    void shouldDetectAllSubstrings(){
        String testStr = "abc";
        List<String> results = new ArrayList<>();
        PalindromePartitioning.returnAllSubStrings(0, testStr, results);
        assertTrue(results.equals(Arrays.asList("a", "b", "c", "bc", "ab", "c", "abc")));
    }

    @Test
    void shouldDetectAllSubstringsWhichArePalindromes(){
        String testStr = "abc";
        List<List<String>> results = new ArrayList<>();
        PalindromePartitioning.dfs(0, testStr, new ArrayList<>(), results);
        assertTrue(results.equals(Arrays.asList(Arrays.asList("a", "b", "c"))));
    }

    @Test
    void shouldDetectAllSubstringsWhichArePalindromes2(){
        String testStr = "aabc";
        List<List<String>> results = new ArrayList<>();
        PalindromePartitioning.dfs(0, testStr, new ArrayList<>(), results);
        assertTrue(results.equals(Arrays.asList(Arrays.asList("a", "a", "b", "c"), Arrays.asList("aa", "b", "c") )));
    }

}