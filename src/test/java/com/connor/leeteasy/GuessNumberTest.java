package com.connor.leeteasy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GuessNumberTest {

    @Test
    void shouldReturnCorrectGuess_FirstAttempt() {
        GuessNumber g = new GuessNumber(10);
        int result = g.guessNumber(10);
        assertEquals(10, result);
    }

    @Test
    void shouldReturnCorrectGuess_TooLow() {
        GuessNumber g = new GuessNumber(10);
        int result = g.guessNumber(3);
        assertEquals(10, result);
    }

    @Test
    void shouldReturnCorrectGuess_TooHigh() {
        GuessNumber g = new GuessNumber(15);
        int result = g.guessNumber(30);
        assertEquals(15, result);
    }
}