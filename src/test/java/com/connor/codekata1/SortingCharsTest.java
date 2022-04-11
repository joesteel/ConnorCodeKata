package com.connor.codekata1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SortingCharsTest {

    @Test
    void shouldSortaSimpleString() {
        SortingChars s = new SortingChars();
        String input = "cabeffggaa";
        String expectedResult = "aaabceffgg";
        assert(s.sortChars(input).equals(expectedResult));
    }


    @Test
    void shouldSortLongString() {
        SortingChars s = new SortingChars();
        String input = "When not studying nuclear physics, Bambi likes to play beach volleyball";
        String expectedResult = "aaaaabbbbcccdeeeeeghhhiiiiklllllllmnnnnooopprsssstttuuvwyyyy";
        String actualResult = s.sortChars(input);
        assert(actualResult.equals(expectedResult));
    }
}