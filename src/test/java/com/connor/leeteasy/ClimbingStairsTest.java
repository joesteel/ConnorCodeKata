package com.connor.leeteasy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClimbingStairsTest {

    @Test
    void shouldWorkForBaseCase0() {
        assertEquals(1, ClimbingStairs.climbStairs(1));
    }

    @Test
    void shouldWorkForBaseCase1() {
        assertEquals(1, ClimbingStairs.climbStairs(1));

    }

    @Test
    void shouldWorkFor2() {
        assertEquals(2, ClimbingStairs.climbStairs(2));

    }

    @Test
    void shouldWorkFor3() {
        assertEquals(3, ClimbingStairs.climbStairs(3));
    }

    @Test
    void shouldWorkFor5() {
        assertEquals(5, ClimbingStairs.climbStairs(4));
    }
}