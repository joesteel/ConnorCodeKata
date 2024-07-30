package com.connor.leeteasy;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class IsSubsequenceTest {

    @Test
    void shouldDetectSubsequence() {
        assertTrue(IsSubsequence.isSubsequence("abc", "ahbgdc"));
    }


    @Test
    void shouldDetectNoSubsequence() {
        assertFalse(IsSubsequence.isSubsequence("abz", "ahbgdc"));
    }

    @Test
    void shouldDetectSubsequenceDuplicate() {
        assertTrue(IsSubsequence.isSubsequence("aabc", "ahabgdc"));
    }

    @Test
    void shouldDetectNoSubsequenceDuplicate() {
        assertFalse(IsSubsequence.isSubsequence("aabz", "ahbgdc"));
    }
}