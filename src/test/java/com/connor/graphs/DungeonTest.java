package com.connor.graphs;


import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class DungeonTest {
    static final int INF =  Integer.MAX_VALUE;

    @Test
    void shouldReturnInfWhenThereAreNoExitsIn1x1Grid() {
        List<List<Integer>> dungeonMap = new ArrayList<>();
        dungeonMap.add(Arrays.asList(INF));
        List<List<Integer>> result = Dungeon.mapGateDistances(dungeonMap);
        assert(result.equals(dungeonMap));
    }

    @Test
    void shouldReturnInfWhenThereAreNoExitsIn2x2Grid() {
        List<List<Integer>> dungeonMap = new ArrayList<>();
        dungeonMap.add(Arrays.asList(INF, -1));
        dungeonMap.add(Arrays.asList(INF, -1));
        List<List<Integer>> result = Dungeon.mapGateDistances(dungeonMap);
        assert(result.equals(dungeonMap));
    }

    @Test
    void shouldReturnCorrectGridWhenThereIsOneExitOn2x2Grid() {
        List<List<Integer>> dungeonMap = new ArrayList<>();
        dungeonMap.add(Arrays.asList(INF, -1));
        dungeonMap.add(Arrays.asList(INF, 0));
        List<List<Integer>> result = Dungeon.mapGateDistances(dungeonMap);
        List<List<Integer>> expectedResult = new ArrayList<>();
        expectedResult.add(Arrays.asList(2, -1));
        expectedResult.add(Arrays.asList(1, 0));
        assert(result.equals(expectedResult));
    }

    @Test
    void shouldReturnCorrectGridWhenThereIsTwoExitsOn2x2Grid() {
        List<List<Integer>> dungeonMap = new ArrayList<>();
        dungeonMap.add(Arrays.asList(INF, 0));
        dungeonMap.add(Arrays.asList(0, INF));
        List<List<Integer>> result = Dungeon.mapGateDistances(dungeonMap);
        List<List<Integer>> expectedResult = new ArrayList<>();
        expectedResult.add(Arrays.asList(1, 0));
        expectedResult.add(Arrays.asList(0, 1));
        assert(result.equals(expectedResult));
    }

    @Test
    void shouldReturnCorrectGridWhenOnA4x2GridWithOneExit() {
        List<List<Integer>> dungeonMap = new ArrayList<>();
        dungeonMap.add(Arrays.asList(INF, -1, INF, INF));
        dungeonMap.add(Arrays.asList(0, INF, INF, INF));
        List<List<Integer>> result = Dungeon.mapGateDistances(dungeonMap);
        List<List<Integer>> expectedResult = new ArrayList<>();
        expectedResult.add(Arrays.asList(1, -1, 3, 4));
        expectedResult.add(Arrays.asList(0, 1, 2, 3));
        assert(result.equals(expectedResult));
    }

    @Test
    void shouldReturnCorrectGridWhenOnA4x4GridWithOneExit() {
        List<List<Integer>> dungeonMap = new ArrayList<>();
        dungeonMap.add(Arrays.asList(INF, -1, INF, INF));
        dungeonMap.add(Arrays.asList(0, INF, INF, INF));
        dungeonMap.add(Arrays.asList(INF, INF, INF, INF));
        dungeonMap.add(Arrays.asList(INF, INF, INF, INF));
        List<List<Integer>> result = Dungeon.mapGateDistances(dungeonMap);
        List<List<Integer>> expectedResult = new ArrayList<>();
        expectedResult.add(Arrays.asList(1, -1, 3, 4));
        expectedResult.add(Arrays.asList(0, 1, 2, 3));
        expectedResult.add(Arrays.asList(1, 2, 3, 4));
        expectedResult.add(Arrays.asList(2, 3, 4, 5));
        assert(result.equals(expectedResult));
    }

    @Test
    void shouldReturnCorrectGridWhenOnA4x4GridWithMultipleExits() {
        List<List<Integer>> dungeonMap = new ArrayList<>();
        dungeonMap.add(Arrays.asList(INF, -1, INF, -1));
        dungeonMap.add(Arrays.asList(0, INF, INF, INF));
        dungeonMap.add(Arrays.asList(INF, INF, INF, INF));
        dungeonMap.add(Arrays.asList(INF, 0, INF, INF));
        List<List<Integer>> result = Dungeon.mapGateDistances(dungeonMap);
        List<List<Integer>> expectedResult = new ArrayList<>();
        expectedResult.add(Arrays.asList(1, -1, 3, -1));
        expectedResult.add(Arrays.asList(0, 1, 2, 3));
        expectedResult.add(Arrays.asList(1, 1, 2, 3));
        expectedResult.add(Arrays.asList(1, 0, 1, 2));
        assert(result.equals(expectedResult));
    }


    @Test
    void shouldReturnInfWhenThereAreNoExitsIn1x1Grid_bfs() {
        List<List<Integer>> dungeonMap = new ArrayList<>();
        dungeonMap.add(Arrays.asList(INF));
        List<List<Integer>> result = Dungeon.mapGateDistances(dungeonMap, 1);
        assert(result.equals(dungeonMap));
    }

    @Test
    void shouldReturnInfWhenThereAreNoExitsIn2x2Grid_bfs() {
        List<List<Integer>> dungeonMap = new ArrayList<>();
        dungeonMap.add(Arrays.asList(INF, -1));
        dungeonMap.add(Arrays.asList(INF, -1));
        List<List<Integer>> result = Dungeon.mapGateDistances(dungeonMap, 1);
        assert(result.equals(dungeonMap));
    }

    @Test
    void shouldReturnCorrectGridWhenThereIsOneExitOn2x2Grid_bfs() {
        List<List<Integer>> dungeonMap = new ArrayList<>();
        dungeonMap.add(Arrays.asList(INF, -1));
        dungeonMap.add(Arrays.asList(INF, 0));
        List<List<Integer>> result = Dungeon.mapGateDistances(dungeonMap, 1);
        List<List<Integer>> expectedResult = new ArrayList<>();
        expectedResult.add(Arrays.asList(2, -1));
        expectedResult.add(Arrays.asList(1, 0));
        assert(result.equals(expectedResult));
    }

    @Test
    void shouldReturnCorrectGridWhenThereIsTwoExitsOn2x2Grid_bfs() {
        List<List<Integer>> dungeonMap = new ArrayList<>();
        dungeonMap.add(Arrays.asList(INF, 0));
        dungeonMap.add(Arrays.asList(0, INF));
        List<List<Integer>> result = Dungeon.mapGateDistances(dungeonMap, 1);
        List<List<Integer>> expectedResult = new ArrayList<>();
        expectedResult.add(Arrays.asList(1, 0));
        expectedResult.add(Arrays.asList(0, 1));
        assert(result.equals(expectedResult));
    }

    @Test
    void shouldReturnCorrectGridWhenOnA4x2GridWithOneExit_bfs() {
        List<List<Integer>> dungeonMap = new ArrayList<>();
        dungeonMap.add(Arrays.asList(INF, -1, INF, INF));
        dungeonMap.add(Arrays.asList(0, INF, INF, INF));
        List<List<Integer>> result = Dungeon.mapGateDistances(dungeonMap, 1);
        List<List<Integer>> expectedResult = new ArrayList<>();
        expectedResult.add(Arrays.asList(1, -1, 3, 4));
        expectedResult.add(Arrays.asList(0, 1, 2, 3));
        assert(result.equals(expectedResult));
    }

    @Test
    void shouldReturnCorrectGridWhenOnA4x4GridWithOneExit_bfs() {
        List<List<Integer>> dungeonMap = new ArrayList<>();
        dungeonMap.add(Arrays.asList(INF, -1, INF, INF));
        dungeonMap.add(Arrays.asList(0, INF, INF, INF));
        dungeonMap.add(Arrays.asList(INF, INF, INF, INF));
        dungeonMap.add(Arrays.asList(INF, INF, INF, INF));
        List<List<Integer>> result = Dungeon.mapGateDistances(dungeonMap, 1);
        List<List<Integer>> expectedResult = new ArrayList<>();
        expectedResult.add(Arrays.asList(1, -1, 3, 4));
        expectedResult.add(Arrays.asList(0, 1, 2, 3));
        expectedResult.add(Arrays.asList(1, 2, 3, 4));
        expectedResult.add(Arrays.asList(2, 3, 4, 5));
        assert(result.equals(expectedResult));
    }

    @Test
    void shouldReturnCorrectGridWhenOnA4x4GridWithMultipleExits_bfs() {
        List<List<Integer>> dungeonMap = new ArrayList<>();
        dungeonMap.add(Arrays.asList(INF, -1, INF, -1));
        dungeonMap.add(Arrays.asList(0, INF, INF, INF));
        dungeonMap.add(Arrays.asList(INF, INF, INF, INF));
        dungeonMap.add(Arrays.asList(INF, 0, INF, INF));
        List<List<Integer>> result = Dungeon.mapGateDistances(dungeonMap, 1);
        List<List<Integer>> expectedResult = new ArrayList<>();
        expectedResult.add(Arrays.asList(1, -1, 3, -1));
        expectedResult.add(Arrays.asList(0, 1, 2, 3));
        expectedResult.add(Arrays.asList(1, 1, 2, 3));
        expectedResult.add(Arrays.asList(1, 0, 1, 2));
        assert(result.equals(expectedResult));
    }


}