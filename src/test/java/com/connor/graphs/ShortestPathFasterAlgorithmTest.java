package com.connor.graphs;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class ShortestPathFasterAlgorithmTest {

    @Test
    void shouldDeserializeEmptyGraphFromString() {
        String serializedGraph = "0";
        List<List<Map.Entry<Integer, Integer>>> graph = ShortestPathFasterAlgorithm.deserializeGraph(serializedGraph);
        assertEquals(0, graph.size());
    }

    @Test
    void shouldDeserializeGraphOfSizeOneFromString() {
        String serializedGraph = "1";
        List<List<Map.Entry<Integer, Integer>>> graph = ShortestPathFasterAlgorithm.deserializeGraph(serializedGraph);
        assertEquals(1, graph.size());
    }

    @Test
    void shouldDeserializeGraphOfSizeFourWithNoConnectionsFromString() {
        String serializedGraph = "4";
        List<List<Map.Entry<Integer, Integer>>> graph = ShortestPathFasterAlgorithm.deserializeGraph(serializedGraph);
        assertEquals(4, graph.size());
    }

    @Test
    void shouldDeserializeGraphOfSizeTwoWithConnectionsFromString() {
        String serializedGraph = "2-vertexStart-2 3-vertexStart-1 2";
        List<List<Map.Entry<Integer, Integer>>> graph = ShortestPathFasterAlgorithm.deserializeGraph(serializedGraph);
        assertEquals(2, graph.size());
        assertTrue(graph.get(0).get(0).getKey() == 2);
        assertTrue(graph.get(0).get(0).getValue() == 3);
        assertTrue(graph.get(1).get(0).getKey() == 1);
        assertTrue(graph.get(1).get(0).getValue() == 2);
    }

    @Test
    void shouldDeserializeGraphOfSizeFourWithConnectionsFromString() {
        String serializedGraph = "4-vertexStart-1 3 2 4-vertexStart-2 3-vertexStart-3 10";
        List<List<Map.Entry<Integer, Integer>>> graph = ShortestPathFasterAlgorithm.deserializeGraph(serializedGraph);
        assertEquals(4, graph.size());
        assertTrue(graph.get(0).get(0).getKey() == 1);
        assertTrue(graph.get(0).get(0).getValue() == 3);
        assertTrue(graph.get(0).get(1).getKey() == 2);
        assertTrue(graph.get(0).get(1).getValue() == 4);
        assertTrue(graph.get(1).get(0).getKey() == 2);
        assertTrue(graph.get(1).get(0).getValue() == 3);
        assertTrue(graph.get(2).get(0).getKey() == 3);
        assertTrue(graph.get(2).get(0).getValue() == 10);
    }

    @Test
    void shouldFindShortestPathsInGraphOfFourNodes() {
        String serializedGraph = "4-vertexStart-1 3 2 4-vertexStart-2 3-vertexStart-3 10";
        List<List<Map.Entry<Integer, Integer>>> graph = ShortestPathFasterAlgorithm.deserializeGraph(serializedGraph);
        int start = 0;
        int target = 1;
        int expectedResult = 3;
        int shortestPath =  ShortestPathFasterAlgorithm.shortestPath(graph, start, target);
        assertEquals(expectedResult, shortestPath);
    }

    @Test
    void shouldFindShortestPathsInGraphOfThreeNodesWithMultiplePaths() {
        String serializedGraph = "3-vertexStart-1 1 2 5-vertexStart-2 0";
        List<List<Map.Entry<Integer, Integer>>> graph = ShortestPathFasterAlgorithm.deserializeGraph(serializedGraph);
        int start = 0;
        int target = 2;
        int expectedResult = 1;
        int shortestPath =  ShortestPathFasterAlgorithm.shortestPath(graph, start, target);
        assertEquals(expectedResult, shortestPath);
    }

    @Test
    void shouldFindShortestPathToDistantTargetInGraphOfFourNodes() {
        String serializedGraph = "4-vertexStart-1 3 2 4-vertexStart-2 3-vertexStart-3 10";
        List<List<Map.Entry<Integer, Integer>>> graph = ShortestPathFasterAlgorithm.deserializeGraph(serializedGraph);
        int start = 0;
        int target = 3;
        int expectedResult = 14;
        int shortestPath =  ShortestPathFasterAlgorithm.shortestPath(graph, start, target);
        assertEquals(expectedResult, shortestPath);
    }

    @Test
    void shouldFindShortestPathToDistantTargetInGraphOfThreeNodesWithMultiplePathsAndACircuit() {
        String serializedGraph = "3-vertexStart-1 4 2 0-vertexStart-2 3-vertexStart-1 1";
        List<List<Map.Entry<Integer, Integer>>> graph = ShortestPathFasterAlgorithm.deserializeGraph(serializedGraph);
        int start = 0;
        int target = 1;
        int expectedResult = 1;
        int shortestPath =  ShortestPathFasterAlgorithm.shortestPath(graph, start, target);
        assertEquals(expectedResult, shortestPath);
    }

    @Test
    void shouldReturnNotFoundWhenTargetDoesntExist() {
        String serializedGraph = "1";
        List<List<Map.Entry<Integer, Integer>>> graph = ShortestPathFasterAlgorithm.deserializeGraph(serializedGraph);
        int start = 0;
        int target = 10;
        int expectedResult = -1;
        int shortestPath =  ShortestPathFasterAlgorithm.shortestPath(graph, start, target);
        assertEquals(expectedResult, shortestPath);
    }

}