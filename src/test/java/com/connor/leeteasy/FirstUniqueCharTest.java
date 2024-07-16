package com.connor.leeteasy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FirstUniqueCharTest {

    @Test
    void shouldIdentifyNoUniqueChars() {
        int result = FirstUniqueChar.firstUniqChar("aabb");
        assertEquals(-1, result);
    }

    @Test
    void shouldIdentifyFirstUniqueChar() {
        int result = FirstUniqueChar.firstUniqChar("abbcc");
        assertEquals(0, result);
    }

    @Test
    void shouldIdentifyFirstUniqueChar2() {
        int result = FirstUniqueChar.firstUniqChar("aabbccd");
        assertEquals(6, result);
    }
}