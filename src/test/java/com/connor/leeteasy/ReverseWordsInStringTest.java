package com.connor.leeteasy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReverseWordsInStringTest {

    @Test
    void shouldReverseSimpleString() {
        assertEquals("abc", ReverseWordsInString.reverseWords("cba"));
    }

    @Test
    void shouldReverseString_WithSpaces() {
        assertEquals("s'teL ekat edoCteeL tsetnoc", ReverseWordsInString.reverseWords("Let's take LeetCode contest"));
        assertEquals("ab cd", ReverseWordsInString.reverseWords("ba dc"));
    }
}