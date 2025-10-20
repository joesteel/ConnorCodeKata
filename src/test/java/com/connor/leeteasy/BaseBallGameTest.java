package com.connor.leeteasy;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BaseBallGameTest {

    @Test
    void shouldComputeBaseBallGameScores() {
        assertEquals(30, BaseBallGame.calPoints(new String[] {"5","2","C","D","+"}));
        assertEquals(27, BaseBallGame.calPoints(new String[] {"5","-2","4","C","D","9","+","+"}));
        assertEquals(0, BaseBallGame.calPoints(new String[] {"1","C"}));
    }
}