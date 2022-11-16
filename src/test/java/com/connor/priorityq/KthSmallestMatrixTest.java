package com.connor.priorityq;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class KthSmallestMatrixTest {

    @Test
    void shouldFindKthSmallestIn1x3Matrix() {
        List<List<Integer>> matrix = new ArrayList<>();
        matrix.add(Arrays.asList(1,2,3));
        int result = KthSmallestMatrix.kthSmallest(matrix, 2);
        assertEquals(2, result);
    }

    @Test
    void shouldFindKthSmallestIn2x3Matrix() {
        List<List<Integer>> matrix = new ArrayList<>();
        matrix.add(Arrays.asList(1,3,5));
        matrix.add(Arrays.asList(0,2,4));
        int result = KthSmallestMatrix.kthSmallest(matrix, 4);
        assertEquals(3, result);
    }

    @Test
    void shouldFindKthSmallestIn3x4Matrix() {
        List<List<Integer>> matrix = new ArrayList<>();
        matrix.add(Arrays.asList(0,4,8));
        matrix.add(Arrays.asList(1,5,9));
        matrix.add(Arrays.asList(2,6,10));
        matrix.add(Arrays.asList(3,7,11));

        int result = KthSmallestMatrix.kthSmallest(matrix, 10);
        assertEquals(9, result);
    }
}