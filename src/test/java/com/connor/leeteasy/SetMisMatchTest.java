package com.connor.leeteasy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SetMisMatchTest {

    @Test
    void shouldFindMisMatchSet() {
        assertArrayEquals(new int[]{1,4}, SetMisMatch.findErrorNums(new int[]{1,1,2,3}));
    }
}