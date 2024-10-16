package com.connor.leeteasy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConstructRectangleTest {

    @Test
    void shouldDetectBestDimensions() {
        assertArrayEquals(new int[]{2,2}, ConstructRectangle.constructRectangle(4));
        assertArrayEquals(new int[]{5,1}, ConstructRectangle.constructRectangle(5));
        assertArrayEquals(new int[]{4,4}, ConstructRectangle.constructRectangle(16));
        assertArrayEquals(new int[]{5,3}, ConstructRectangle.constructRectangle(15));
        assertArrayEquals(new int[]{17,1}, ConstructRectangle.constructRectangle(17));
    }
}