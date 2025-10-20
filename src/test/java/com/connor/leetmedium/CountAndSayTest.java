package com.connor.leetmedium;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CountAndSayTest {

    @Test
    void shouldCountAndSay() {
        assertEquals("1", CountAndSay.countAndSay(1));
        assertEquals("11", CountAndSay.countAndSay(2));
        assertEquals("21", CountAndSay.countAndSay(3));
        assertEquals("1211", CountAndSay.countAndSay(4));
        assertEquals("111221", CountAndSay.countAndSay(5));
        assertEquals("312211", CountAndSay.countAndSay(6));
        assertEquals("13112221", CountAndSay.countAndSay(7));
    }
}