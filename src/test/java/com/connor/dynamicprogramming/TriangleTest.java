package com.connor.dynamicprogramming;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TriangleTest {


    @Test
    void shouldReturnResultForTriangleOfSizeTwo() {
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(new ArrayList<>(Arrays.asList(0)));
        triangle.add(new ArrayList<>(Arrays.asList(1,2)));
        int result = Triangle.minimumTotal(triangle);
        assertEquals(1, result);
    }

    @Test
    void shouldReturnResultForLargeTriangle() {
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(new ArrayList<>(Arrays.asList(0)));
        triangle.add(new ArrayList<>(Arrays.asList(1,2)));
        triangle.add(new ArrayList<>(Arrays.asList(3,4,5)));
        triangle.add(new ArrayList<>(Arrays.asList(6,7,8,9)));

        int result = Triangle.minimumTotal(triangle);
        assertEquals(10, result);
    }

    @Test
    void shouldReturnResultForLargeComplexTriangle() {
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(new ArrayList<>(Arrays.asList(0)));
        triangle.add(new ArrayList<>(Arrays.asList(1,0)));
        triangle.add(new ArrayList<>(Arrays.asList(3,0,5)));
        triangle.add(new ArrayList<>(Arrays.asList(6, 7 ,0,9)));
        triangle.add(new ArrayList<>(Arrays.asList(10,11,0,13,14)));
        triangle.add(new ArrayList<>(Arrays.asList(14,15,16,0,18,19)));

        int result = Triangle.minimumTotal(triangle);
        assertEquals(0, result);
    }

    @Test
    void shouldReturnResultForTriangleWithDuplicateSubtrees() {
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(new ArrayList<>(Arrays.asList(0)));
        triangle.add(new ArrayList<>(Arrays.asList(0,0)));
        triangle.add(new ArrayList<>(Arrays.asList(0,0,0)));
        triangle.add(new ArrayList<>(Arrays.asList(0,0,0,0)));
        triangle.add(new ArrayList<>(Arrays.asList(0,0,0,0,0)));
        triangle.add(new ArrayList<>(Arrays.asList(0,0,0,0,0,19)));
        int result = Triangle.minimumTotal(triangle);
        assertEquals(0, result);
    }


    @Test
    void shouldReturnResultForTriangleOfSizeTwo_BO() {
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(new ArrayList<>(Arrays.asList(0)));
        triangle.add(new ArrayList<>(Arrays.asList(1,2)));
        int result = Triangle.minimumTotal(triangle,Triangle.BO);
        assertEquals(1, result);
    }

    @Test
    void shouldReturnResultForLargeTriangle_BO() {
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(new ArrayList<>(Arrays.asList(0)));
        triangle.add(new ArrayList<>(Arrays.asList(1,2)));
        triangle.add(new ArrayList<>(Arrays.asList(3,4,5)));
        triangle.add(new ArrayList<>(Arrays.asList(6,7,8,9)));

        int result = Triangle.minimumTotal(triangle,Triangle.BO);
        assertEquals(10, result);
    }

}