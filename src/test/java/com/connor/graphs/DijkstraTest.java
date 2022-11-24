package com.connor.graphs;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class DijkstraTest {


    @Test
    void shouldFindShortestPathsInGraphOfThreeNodesWithMultiplePaths() {
        String serializedGraph = "3-vertexStart-1 1 2 5-vertexStart-2 0";
        List<List<Map.Entry<Integer, Integer>>> graph = GraphHelper.deserializeGraph(serializedGraph);
        int start = 0;
        int target = 2;
        int expectedResult = 1;
        int shortestPath =  Dijkstra.shortestPath(graph, start, target);
        assertEquals(expectedResult, shortestPath);
    }

    @Test
    void shouldFindShortestPathToDistantTargetInGraphOfFourNodes() {
        String serializedGraph = "4-vertexStart-1 3 2 4-vertexStart-2 3-vertexStart-3 10";
        List<List<Map.Entry<Integer, Integer>>> graph = GraphHelper.deserializeGraph(serializedGraph);
        int start = 0;
        int target = 3;
        int expectedResult = 14;
        int shortestPath =  Dijkstra.shortestPath(graph, start, target);
        assertEquals(expectedResult, shortestPath);
    }

    @Test
    void shouldFindShortestPathToDistantTargetInGraphOfThreeNodesWithMultiplePathsAndACircuit() {
        String serializedGraph = "3-vertexStart-1 4 2 0-vertexStart-2 3-vertexStart-1 1";
        List<List<Map.Entry<Integer, Integer>>> graph = GraphHelper.deserializeGraph(serializedGraph);
        int start = 0;
        int target = 1;
        int expectedResult = 1;
        int shortestPath =  Dijkstra.shortestPath(graph, start, target);
        assertEquals(expectedResult, shortestPath);
    }

}