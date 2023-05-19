package com.connor.dynamicprogramming;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RobotPathsTest {

    @Test
    void shouldReturn1For1x1Grid() {
        int m = 1, n =1;
        int result = RobotPaths.uniquePaths(m,n);
        assertEquals(1, result);
    }


    @Test
    void shouldReturn1For2x1Grid() {
        int m = 2, n = 1;
        int result = RobotPaths.uniquePaths(m,n);
        assertEquals(1, result);
    }


    @Test
    void shouldReturn2For2x2Grid() {
        int m = 2, n =2;
        int result = RobotPaths.uniquePaths(m,n);
        assertEquals(2, result);
    }

    @Test
    void shouldReturn6For3x3Grid() {
        int m = 3, n = 3;
        int result = RobotPaths.uniquePaths(m,n);
        assertEquals(6, result);
    }

    @Test
    void shouldReturn3For2x3Grid() {
        int m = 2, n = 3;
        int result = RobotPaths.uniquePaths(m,n);
        assertEquals(3, result);
    }


    @Test
    void shouldReturn1For1x1Grid_BU() {
        int m = 1, n =1;
        int result = RobotPaths.uniquePathsBottomUp(m,n);
        assertEquals(1, result);
    }


    @Test
    void shouldReturn1For2x1Grid_BU() {
        int m = 2, n = 1;
        int result = RobotPaths.uniquePathsBottomUp(m,n);
        assertEquals(1, result);
    }

    @Test
    void shouldReturn2For2x2Grid_BU() {
        int m = 2, n =2;
        int result = RobotPaths.uniquePathsBottomUp(m,n);
        assertEquals(2, result);
    }

    @Test
    void shouldReturn6For3x3Grid_BU() {
        int m = 3, n = 3;
        int result = RobotPaths.uniquePathsBottomUp(m,n);
        assertEquals(6, result);
    }

    @Test
    void shouldReturn3For2x3Grid_BU() {
        int m = 2, n = 3;
        int result = RobotPaths.uniquePathsBottomUp(m,n);
        assertEquals(3, result);
    }

}