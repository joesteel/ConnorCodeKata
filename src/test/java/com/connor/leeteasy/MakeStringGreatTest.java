package com.connor.leeteasy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MakeStringGreatTest {
    @Test
    void shouldDoNothingForEmptyString() {
        String result = MakeStringGreat.makeGood("");
        assertEquals("", result);
    }

    @Test
    void shouldDoNothingForGreatString() {
        String result = MakeStringGreat.makeGood("abc");
        assertEquals("abc", result);
    }


    @Test
    void shouldFixString() {
        String result = MakeStringGreat.makeGood("aA");
        assertEquals("", result);
    }


    @Test
    void shouldFixString2() {
        String result = MakeStringGreat.makeGood("aAabc");
        assertEquals("abc", result);
    }

    @Test
    void shouldFixString3() {
        String result = MakeStringGreat.makeGood("Pp");
        assertEquals("", result);
    }
    @Test
    void shouldFixString_complex() {
        String result = MakeStringGreat.makeGood("baABbc");
        assertEquals("bc", result);
    }

    @Test
    void shouldFixString_complex2() {
        String result = MakeStringGreat.makeGood("abBAcC");
        assertEquals("", result);
    }
}