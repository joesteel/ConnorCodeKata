package com.connor.graphs;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

class CoordinateTest {

    @Test
    void shouldUseHashCodeToDetectCollisionsInHashSet() {
        Coordinate a = new Coordinate(0,0);
        HashSet<Coordinate> set = new HashSet<>();
        set.add(a);
        Coordinate b = new Coordinate(0,0);
        boolean result = set.contains(b);
        assertTrue(result);
    }


    @Test
    void shouldUseHashCodeToDetectCollisionsInHashSet2() {
        Coordinate a = new Coordinate(-1,-4);
        HashSet<Coordinate> set = new HashSet<>();
        set.add(a);
        Coordinate b = new Coordinate(-1,-4);
        boolean result = set.contains(b);
        assertTrue(result);
    }
}