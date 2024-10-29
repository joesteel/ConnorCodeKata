package com.connor.leeteasy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TeemoAttackingTest {
    @Test
    void shouldWorkForNonOverLappingInterval() {
        int result = TeemoAttacking.findPoisonedDuration(new int[]{1,4,6,9}, 2);
        assertEquals(8, result);
    }

    @Test
    void shouldWorkForOverLappingIntervals() {
        int result = TeemoAttacking.findPoisonedDuration(new int[]{1,3,5}, 3);
        assertEquals(7, result);
    }
}