package com.connor.codekata1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongestSubStringTest {


    @Test
    void shouldDealWithCrap() {
        LongestSubString longestSubString = new LongestSubString();
        int result = longestSubString.lengthOfLongestSubstring(" ");
        int expected_result = 1;
        assert(result == expected_result);
    }

    @Test
    void shouldReturnZeroForAnEmptyString() {
        LongestSubString longestSubString = new LongestSubString();
        int result = longestSubString.lengthOfLongestSubstring("");
        int expected_result = 0;
        assert(result == expected_result);
    }

    @Test
    void shouldReturnZeroForAOneCharString() {
        LongestSubString longestSubString = new LongestSubString();
        int result = longestSubString.lengthOfLongestSubstring("a");
        int expected_result = 1;
        assert(result == expected_result);
    }

    @Test
    void shouldReturnZeroForARepeatingOneCharString() {
        LongestSubString longestSubString = new LongestSubString();
        int result = longestSubString.lengthOfLongestSubstring("aa");
        int expected_result = 1;
        assert(result == expected_result);
    }


    @Test
    void shouldReturnMaxlenghForABunchOfNonRepeatingChars() {
        LongestSubString longestSubString = new LongestSubString();
        int result = longestSubString.lengthOfLongestSubstring("abcdefghijk");
        int expected_result = 11;
        assert(result == expected_result);
    }

    @Test
    void shouldReturnASubstringWhenAllDuplicates() {
        LongestSubString longestSubString = new LongestSubString();
        int result = longestSubString.lengthOfLongestSubstring("bbbbbbbbb");
        int expected_result = 1;
        assert(result == expected_result);
    }


    @Test
    void shouldReturnASubstringWhenSomeDuplicates() {
        LongestSubString longestSubString = new LongestSubString();
        int result = longestSubString.lengthOfLongestSubstring("bbcdefgc");
        int expected_result = 6;
        assert(result == expected_result);
    }

    @Test
    void shouldReturnASubstringWhenSomeComplexDuplicates() {
        LongestSubString longestSubString = new LongestSubString();
        int result = longestSubString.lengthOfLongestSubstring("bbcdefgcbbcdefgcbbcdefgc");
        int expected_result = 6;
        assert(result == expected_result);
    }



}