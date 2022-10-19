package com.connor.graphs;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ShortestPathTest {

    @Test
    void shouldReturnZeroForOneVertexGraph() {
        List<List<Integer>> graph = Arrays.asList(Arrays.asList());
        int result = ShortestPath.shortestPath(graph, 0, 0);
        assertEquals(0, result);
    }

    @Test
    void shouldReturnOneForOneVertexGraph() {
        List<List<Integer>> graph = Arrays.asList(Arrays.asList(1, 2), Arrays.asList(2, 3), Arrays.asList(), Arrays.asList());
        int result = ShortestPath.shortestPath(graph, 0, 1);
        assertEquals(1, result);
    }

    @Test
    void shouldReturnTwoFoDistanceOfTwo() {
        List<List<Integer>> graph = Arrays.asList(Arrays.asList(1, 2), Arrays.asList(2, 3), Arrays.asList(), Arrays.asList());
        int result = ShortestPath.shortestPath(graph, 0, 3);
        assertEquals(2, result);
    }

    @Test
    void shouldReturnTwoFoDistanceOfThree() {
        List<List<Integer>> graph = Arrays.asList(Arrays.asList(1, 2), Arrays.asList(2, 3), Arrays.asList(3), Arrays.asList(4), Arrays.asList());
        int result = ShortestPath.shortestPath(graph, 0, 4);
        assertEquals(3, result);
    }

    @Test
    void shouldReturnNotFoundWhenTargetVertexNotInGraph() {
        List<List<Integer>> graph = Arrays.asList(Arrays.asList(1, 2), Arrays.asList(2, 3), Arrays.asList(3), Arrays.asList(4), Arrays.asList());
        int result = ShortestPath.shortestPath(graph, 0, 10);
        assertEquals(-1, result);
    }
}