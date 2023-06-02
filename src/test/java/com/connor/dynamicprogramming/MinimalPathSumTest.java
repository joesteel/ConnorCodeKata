package com.connor.dynamicprogramming;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MinimalPathSumTest {
    @Test
    void shouldReturnCorrectAnswerFor1x1Grid_td() {
        List<List<Integer>> grid = new ArrayList<>();
        grid.add(new ArrayList<>(Arrays.asList(1)));
        int result = MinimalPathSum.minPathSum(grid);
        assertEquals(1, result);
    }

    @Test
    void shouldReturnCorrectAnswerFor2x2Grid_td() {
        List<List<Integer>> grid = new ArrayList<>();
        grid.add(new ArrayList<>(Arrays.asList(1, 1)));
        grid.add(new ArrayList<>(Arrays.asList(10, 1)));
        int result = MinimalPathSum.minPathSum(grid);
        assertEquals(3, result);
    }

    @Test
    void shouldReturnCorrectAnswerFor3x3Grid_td() {
        List<List<Integer>> grid = new ArrayList<>();
        grid.add(new ArrayList<>(Arrays.asList(1, 3, 1)));
        grid.add(new ArrayList<>(Arrays.asList(1, 5, 1)));
        grid.add(new ArrayList<>(Arrays.asList(4, 2, 1)));

        int result = MinimalPathSum.minPathSum(grid);
        assertEquals(7, result);
    }

}