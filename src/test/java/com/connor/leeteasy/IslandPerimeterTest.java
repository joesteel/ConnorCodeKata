package com.connor.leeteasy;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class IslandPerimeterTest {

    @Test
    void shouldGetCorrectPerimeterForIslandSizeOne() {
        int[][] grid = new int[4][4];
        for (int[] ints : grid) {
            Arrays.fill(ints, 0);
        }
        grid[0][1] = 1;
        int result = IslandPerimeter.islandPerimeter(grid);
        assertEquals(4, result);
    }

    @Test
    void shouldGetCorrectPerimeterForIslandSizeTwo() {
        int[][] grid = new int[4][4];
        for (int[] ints : grid) {
            Arrays.fill(ints, 0);
        }
        grid[0][1] = 1;
        grid[0][2] = 1;
        int result = IslandPerimeter.islandPerimeter(grid);
        assertEquals(6, result);
    }

    @Test
    void shouldGetCorrectPerimeterForIslandSizeThree() {
        int[][] grid = new int[4][4];
        for (int[] ints : grid) {
            Arrays.fill(ints, 0);
        }
        grid[0][1] = 1;
        grid[0][2] = 1;
        grid[1][1] = 1;
        int result = IslandPerimeter.islandPerimeter(grid);
        assertEquals(8, result);
    }

    @Test
    void shouldGetCorrectPerimeterForIslandSizeFive() {
        int[][] grid = new int[4][4];
        for (int[] ints : grid) {
            Arrays.fill(ints, 0);
        }
        grid[0][1] = 1;
        grid[1][1] = 1;
        grid[2][1] = 1;
        grid[1][0] = 1;
        grid[1][2] = 1;

        int result = IslandPerimeter.islandPerimeter(grid);
        assertEquals(12, result);
    }
}