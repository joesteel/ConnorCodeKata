package com.connor.leetmedium;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LetterCombinationsPhoneTest {

    @Test
    void shouldCreateAllLetterCombinations() {
        assertEquals( new ArrayList<String>(), LetterCombinationsPhone.letterCombinations(""));
        assertEquals( new ArrayList<String>(Arrays.asList("a","b","c")), LetterCombinationsPhone.letterCombinations("2"));
        assertEquals( new ArrayList<String>(Arrays.asList("ad","ae","af","bd","be","bf","cd","ce","cf")), LetterCombinationsPhone.letterCombinations("23"));
    }
}