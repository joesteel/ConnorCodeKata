package com.connor.leeteasy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RobotReturnToOriginTest {

    @Test
    void shouldDetectIfReturnsToOrigin() {
        assertTrue(RobotReturnToOrigin.judgeCircle(""));
        assertFalse(RobotReturnToOrigin.judgeCircle("D"));
        assertTrue(RobotReturnToOrigin.judgeCircle("UUDDLLRR"));
    }
}