package com.connor.graphs;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NumberOfIslandsTest {

    @Test
    void shouldDetectIslandOn1x1Grid() {
        List<List<Integer>> grid = new ArrayList<>();
        grid.add(Arrays.asList(1));
        int result = NumberOfIslands.countNumberOfIslands(grid);
        assertEquals(1, result);
    }
    @Test
    void shouldDetectNoIslandsOn1x1Grid() {
        List<List<Integer>> grid = new ArrayList<>();
        grid.add(Arrays.asList(0));
        int result = NumberOfIslands.countNumberOfIslands(grid);
        assertEquals(0, result);
    }
    @Test
    void shouldDetectIslandOn2x2Grid() {
        List<List<Integer>> grid = new ArrayList<>();
        grid.add(Arrays.asList(1, 0));
        grid.add(Arrays.asList(0, 0));
        int result = NumberOfIslands.countNumberOfIslands(grid);
        assertEquals(1, result);
    }
    @Test
    void shouldDetectTwoIslandOn3x3Grid() {
        List<List<Integer>> grid = new ArrayList<>();
        grid.add(Arrays.asList(1, 0, 0));
        grid.add(Arrays.asList(0, 0, 0));
        grid.add(Arrays.asList(0, 0, 1));
        int result = NumberOfIslands.countNumberOfIslands(grid);
        assertEquals(2, result);
    }

    @Test
    void shouldDetectTwoIslandOn4x4Grid() {
        List<List<Integer>> grid = new ArrayList<>();
        grid.add(Arrays.asList(1, 1, 1, 0));
        grid.add(Arrays.asList(1, 0, 0, 0));
        grid.add(Arrays.asList(0, 0, 1, 1));
        grid.add(Arrays.asList(0, 0, 0, 0));
        int result = NumberOfIslands.countNumberOfIslands(grid);
        assertEquals(2, result);
    }

    @Test
    void shouldDetectThreeIslandOn4x4Grid() {
        List<List<Integer>> grid = new ArrayList<>();
        grid.add(Arrays.asList(1, 1, 1, 0));
        grid.add(Arrays.asList(1, 0, 0, 0));
        grid.add(Arrays.asList(0, 0, 1, 1));
        grid.add(Arrays.asList(1, 0, 0, 0));
        int result = NumberOfIslands.countNumberOfIslands(grid);
        assertEquals(3, result);
    }

    @Test
    void shouldDetectNoIslandsOnEmpty4x4Grid() {
        List<List<Integer>> grid = new ArrayList<>();
        grid.add(Arrays.asList(0, 0, 0, 0));
        grid.add(Arrays.asList(0, 0, 0, 0));
        grid.add(Arrays.asList(0, 0, 0, 0));
        grid.add(Arrays.asList(0, 0, 0, 0));
        int result = NumberOfIslands.countNumberOfIslands(grid);
        assertEquals(0, result);
    }

}