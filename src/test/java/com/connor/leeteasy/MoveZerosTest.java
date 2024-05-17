package com.connor.leeteasy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MoveZerosTest {

    @Test
    void shouldMoveZeros_1() {
        int[] nums = new int[]{0};
        MoveZeros.moveZeroes(nums);
        int[] expected = new int[]{0};
        assertArrayEquals(expected, nums);
    }

    @Test
    void shouldMoveZeros_2() {
        int[] nums = new int[]{0,1};
        MoveZeros.moveZeroes(nums);
        int[] expected = new int[]{1,0};
        assertArrayEquals(expected, nums);
    }

    @Test
    void shouldMoveZeros_3() {
        int[] nums = new int[]{0,0,1};
        MoveZeros.moveZeroes(nums);
        int[] expected = new int[]{1,0,0};
        assertArrayEquals(expected, nums);
    }

    @Test
    void shouldMoveZeros_4() {
        int[] nums = new int[]{0,0,1,0,3};
        MoveZeros.moveZeroes(nums);
        int[] expected = new int[]{1,3,0,0,0};
        assertArrayEquals(expected, nums);
    }

    @Test
    void shouldMoveZeros_5() {
        int[] nums = new int[]{1,2};
        MoveZeros.moveZeroes(nums);
        int[] expected = new int[]{1,2};
        assertArrayEquals(expected, nums);
    }

    @Test
    void shouldMoveZeros_6() {
        int[] nums = new int[]{1,0,0,2,0,3};
        MoveZeros.moveZeroes(nums);
        int[] expected = new int[]{1,2,3,0,0,0};
        assertArrayEquals(expected, nums);
    }
}