package com.connor.priorityq;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class KClosestPointsTest {

    @Test
    void shouldReturnClosestPointFromListOfOne() {
        List<List<Integer>> points = new ArrayList<>(Arrays.asList(
                Arrays.asList(1,1)
        ));
        List<List<Integer>> result = KClosestPoints.kClosestPoints(points, 1);
        assertEquals(1, result.size());
        assertTrue(result.get(0).equals(Arrays.asList(1,1)));
    }

    @Test
    void shouldReturnClosestPointFromListOfFive() {
        List<List<Integer>> points = new ArrayList<>(Arrays.asList(
                Arrays.asList(1,1),
                Arrays.asList(5,5),
                Arrays.asList(0,0),
                Arrays.asList(10,10),
                Arrays.asList(2,2)
                ));
        List<List<Integer>> result = KClosestPoints.kClosestPoints(points, 3);
        assertEquals(3, result.size());
        assertTrue(result.get(0).equals(Arrays.asList(0,0)));
        assertTrue(result.get(1).equals(Arrays.asList(1,1)));
        assertTrue(result.get(2).equals(Arrays.asList(2,2)));
    }

}