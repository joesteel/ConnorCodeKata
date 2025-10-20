package com.connor.leetmedium;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class dDailyTemperaturesTest {

    @Test
    void shouldReturnAnswerForSimpleIncreasing() {
        int[] temps = new int[]{1,2,3};
        int[] result = DailyTemperatures.dailyTemperatures(temps);
        assertArrayEquals(new int[]{1,1,0}, result);
    }

    @Test
    void shouldReturnAnswerForSimpleDecreasing() {
        int[] temps = new int[]{3,2,1};
        int[] result = DailyTemperatures.dailyTemperatures(temps);
        assertArrayEquals(new int[]{0,0,0},result);
    }

    @Test
    void shouldReturnAnswerForHighVariance() {
        int[] temps = new int[]{73,74,75,71,69,72,76,73};
        int[] result = DailyTemperatures.dailyTemperatures(temps);
        assertArrayEquals(new int[]{1,1,4,2,1,1,0,0},result);
    }
}