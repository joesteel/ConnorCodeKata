package com.connor.leeteasy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrangingCoinsTest {

    @Test
    void shouldGuessCorrectColumns() {
        assertEquals(1, ArrangingCoins.arrangeCoins(1));
        assertEquals(1, ArrangingCoins.arrangeCoins(2));
        assertEquals(2, ArrangingCoins.arrangeCoins(3));
        assertEquals(2, ArrangingCoins.arrangeCoins(4));
        assertEquals(2, ArrangingCoins.arrangeCoins(5));
        assertEquals(3, ArrangingCoins.arrangeCoins(6));
        assertEquals(3, ArrangingCoins.arrangeCoins(7));
        assertEquals(4, ArrangingCoins.arrangeCoins(10));
        assertEquals(11, ArrangingCoins.arrangeCoins(66));
        assertEquals(65535, ArrangingCoins.arrangeCoins(Integer.MAX_VALUE));
    }
}