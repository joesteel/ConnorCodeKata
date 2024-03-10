package com.connor.leeteasy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HappyNumbersTest {
    @Test
    void shouldHandleBaseCase1() {
        assertTrue(HappyNumbers.isHappy(1));
    }

    @Test
    void shouldHandleBaseCaseNot3() {
        assertFalse(HappyNumbers.isHappy(3));
    }

    @Test
    void shouldHandleBaseCaseNo4() {
        assertFalse(HappyNumbers.isHappy(4));
    }

    @Test
    void shouldHandleBaseCaseNo5() {
        assertFalse(HappyNumbers.isHappy(5));
    }

    @Test
    void shouldHandleBaseCaseNot6() {
        assertFalse(HappyNumbers.isHappy(6));
    }

    @Test
    void shouldHandleBaseCaseNot7() {
        assertTrue(HappyNumbers.isHappy(7));
    }

    @Test
    void shouldHandleBaseCaseNot8() {
        assertFalse(HappyNumbers.isHappy(8));
    }

    @Test
    void shouldHandleBaseCase9() {
        assertFalse(HappyNumbers.isHappy(9));
    }

    @Test
    void shouldHandle10() {
        assertTrue(HappyNumbers.isHappy(10));
    }

    @Test
    void shouldHandle19() {
        assertTrue(HappyNumbers.isHappy(19));
    }

    @Test
    void shouldHandle1104() {
        assertTrue(HappyNumbers.isHappy(11104));
    }

}