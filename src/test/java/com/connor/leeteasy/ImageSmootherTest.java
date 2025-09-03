package com.connor.leeteasy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ImageSmootherTest {

    @Test
    void shouldSmoothImage_simple3x3() {
        int[][] img = { {1,1,1}, {1,1,1}, {1,1,1} };
        int[][] expected = { {1,1,1}, {1,1,1}, {1,1,1} };
        assertArrayEquals(expected, ImageSmoother.imageSmoother(img));
    }

    @Test
    void shouldSmoothImage_empty() {
        int[][] img = { {}, {}, {} };
        int[][] expected = { {}, {}, {} };
        assertArrayEquals(expected, ImageSmoother.imageSmoother(img));
    }

    @Test
    void shouldSmoothImage_2x2() {
        int[][] img = { {1,1}, {1,1}, {1,1} };
        int[][] expected = { {1,1}, {1,1}, {1,1} };
        assertArrayEquals(expected, ImageSmoother.imageSmoother(img));
    }

    @Test
    void shouldSmoothImageAndFloorDown() {
        int[][] img = { {1,1,1}, {1,0,1}, {1,1,1} };
        int[][] expected = { {0,0,0}, {0,0,0}, {0,0,0} };
        assertArrayEquals(expected, ImageSmoother.imageSmoother(img));
    }

    @Test
    void shouldSmoothImage_complex() {
        int[][] img = { {100,200,100},{200,50,200},{100,200,100} };
        int[][] expected = { {137,141,137},{141,138,141},{137,141,137} };
        assertArrayEquals(expected, ImageSmoother.imageSmoother(img));
    }
}