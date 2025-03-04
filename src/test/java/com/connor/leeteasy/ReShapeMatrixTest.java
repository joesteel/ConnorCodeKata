package com.connor.leeteasy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReShapeMatrixTest {

    @Test
    void shouldReshapeMatrix_HappyPath() {
        assertArrayEquals(new int[][]{{1},{2},{3},{4}}, ReShapeMatrix.matrixReshape(new int[][] {{1,2},{3,4}}, 4,1));
        assertArrayEquals(new int[][]{{1,2,3,4}}, ReShapeMatrix.matrixReshape(new int[][] {{1,2},{3,4}}, 1,4));
    }

    @Test
    void shouldReshapeMatrix_UnHappyPath() {
        assertArrayEquals(new int[][]{{}}, ReShapeMatrix.matrixReshape(new int[][] {{}}, 10,10));
        assertArrayEquals(new int[][]{{1,2},{3,4}}, ReShapeMatrix.matrixReshape(new int[][] {{1,2},{3,4}}, -1,-3));
        assertArrayEquals(new int[][]{{1,2},{3,4}}, ReShapeMatrix.matrixReshape(new int[][] {{1,2},{3,4}}, 1,3));
    }
}