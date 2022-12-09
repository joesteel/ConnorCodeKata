package com.connor.twopointers;

import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MoveZerosTest {

    @Test
    void shouldReturnNoChangeForArrWithNoZeros() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1,2,3));
        MoveZeros.moveZeros(input);
        assertTrue(input.equals(Arrays.asList(1,2,3)));
    }

    @Test
    void shouldReturnNoChangeForArrSize2WithOneZeroAtStart() {
        List<Integer> input = new ArrayList<>(Arrays.asList(0,1));
        MoveZeros.moveZeros(input);
        assertTrue(input.equals(Arrays.asList(1,0)));
    }

    @Test
    void shouldReturnNoChangeForArrWithOneZeroAtStart() {
        List<Integer> input = new ArrayList<>(Arrays.asList(0,1,2,3));
        MoveZeros.moveZeros(input);
        assertTrue(input.equals(Arrays.asList(1,2,3,0)));
    }


    @Test
    void shouldReturnNoChangeForArrWithOneZeroAtEnd() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1,2,3,0));
        MoveZeros.moveZeros(input);
        assertTrue(input.equals(Arrays.asList(1,2,3,0)));
    }

    @Test
    void shouldReturnNoChangeForArrWithMultipleZeros() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1,0,2,0,3));
        MoveZeros.moveZeros(input);
        assertTrue(input.equals(Arrays.asList(1,2,3,0,0)));
    }

}