package com.connor.dynamicprogramming;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DivisorGameTest {

    @Test
    void shouldLoseGameWhenStartingFrom1() {
        boolean winGame = DivisorGame.divisorGame(1);
        assertEquals(false, winGame);
    }

    @Test
    void shouldWinGameWhenStartingFrom2() {
        boolean winGame = DivisorGame.divisorGame(2);
        assertEquals(true, winGame);
    }

    @Test
    void shouldLoseGameWhenStartingFrom3() {
        boolean winGame = DivisorGame.divisorGame(15);
        assertEquals(false, winGame);
    }

}