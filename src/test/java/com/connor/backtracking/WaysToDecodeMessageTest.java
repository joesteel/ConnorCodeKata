package com.connor.backtracking;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WaysToDecodeMessageTest {

    @Test
    void shouldGetWaysToDecodeSimpleMessage() {
        int result = WaysToDecodeMessage.decodeWays("1");
        assertEquals(1, result);
    }

    @Test
    void shouldGetWaysToDecodeSimpleMessage2() {
        int result = WaysToDecodeMessage.decodeWays("18");
        assertEquals(2, result);
    }

    @Test
    void shouldGetWaysToDecodeSimpleMessage3() {
        int result = WaysToDecodeMessage.decodeWays("123");
        assertEquals(3, result);
    }

}