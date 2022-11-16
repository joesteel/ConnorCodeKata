package com.connor.graphs;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class TaskSchedulingWithTimesTest {

    @Test
    void shouldCreateGraph() {
        List<String> tasks = new ArrayList<>(Arrays.asList("a", "b", "c", "d"));
        List<List<String>> dependencies = new ArrayList<>(
                Arrays.asList(
                        Arrays.asList("a", "b"),
                        Arrays.asList("a", "c"),
                        Arrays.asList("b", "d"),
                        Arrays.asList("c", "d")
                ));
        Map<String, List<String>> graph = TaskSchedulingWithTimes.createGraphMap(tasks, dependencies);
        assertEquals(4, graph.size());
        assertTrue(graph.get("a").equals(Arrays.asList("b", "c")));
        assertTrue(graph.get("b").equals(Arrays.asList("d")));
        assertTrue(graph.get("c").equals(Arrays.asList("d")));
        assertTrue(graph.get("d").equals(Arrays.asList()));
    }

    @Test
    void shouldCountParents() {
        List<String> tasks = new ArrayList<>(Arrays.asList("a", "b", "c", "d"));
        List<List<String>> dependencies = new ArrayList<>(
                Arrays.asList(
                        Arrays.asList("a", "b"),
                        Arrays.asList("a", "c"),
                        Arrays.asList("b", "d"),
                        Arrays.asList("c", "d")
                ));
        Map<String, List<String>> graph = TaskSchedulingWithTimes.createGraphMap(tasks, dependencies);
        Map<String, Integer> parentCount = TaskSchedulingWithTimes.countIncomingEdges(graph);
        assertEquals(graph.size(), parentCount.size());
        assertTrue(parentCount.get("a") == 0);
        assertTrue(parentCount.get("b") == 1);
        assertTrue(parentCount.get("c") == 1);
        assertTrue(parentCount.get("d") == 2);
    }

    @Test
    void shouldReturnMinTimeToExecuteEmptyDAG() {
        List<String> tasks = new ArrayList<>(Arrays.asList());
        List<List<String>> dependencies = new ArrayList<>();
        List<Integer> times = new ArrayList<>();
        int result = TaskSchedulingWithTimes.taskScheduling2(tasks, times, dependencies);
        assertEquals(0, result);
    }

    @Test
    void shouldReturnMinTimeToExecuteEmptyDAGWithOneVertex() {
        List<String> tasks = new ArrayList<>(Arrays.asList("a"));
        List<List<String>> dependencies = new ArrayList<>();
        List<Integer> times = new ArrayList<>(Arrays.asList(1));
        int result = TaskSchedulingWithTimes.taskScheduling2(tasks, times, dependencies);
        assertEquals(1, result);
    }

    @Test
    void shouldReturnMinTimeToExecuteEmptyDAGWith4Levels() {
        List<String> tasks = new ArrayList<>(Arrays.asList("a", "b", "c", "d"));
        List<List<String>> dependencies = new ArrayList<>(
                Arrays.asList(
                        Arrays.asList("a", "b"),
                        Arrays.asList("a", "c"),
                        Arrays.asList("b", "d"),
                        Arrays.asList("c", "d")
                ));
        List<Integer> times = new ArrayList<>(Arrays.asList(1,2,3,4));
        int result = TaskSchedulingWithTimes.taskScheduling2(tasks, times, dependencies);
        assertEquals(1+3+4, result);
    }


    @Test
    void shouldReturnMinTimeToExecuteEmptyDAGWith7Levels() {
        List<String> tasks = new ArrayList<>(Arrays.asList("abbreviate", "bricks", "cardinals", "dextrous", "fibre", "green", "height"));
        List<List<String>> dependencies = new ArrayList<>(
                Arrays.asList(
                        Arrays.asList("abbreviate", "bricks"),
                        Arrays.asList("cardinals", "bricks"),
                        Arrays.asList("dextrous", "bricks"),
                        Arrays.asList("bricks", "fibre"),
                        Arrays.asList("green", "fibre")

                ));
        List<Integer> times = new ArrayList<>(Arrays.asList(1, 1, 1, 1, 1, 100, 1));
        int result = TaskSchedulingWithTimes.taskScheduling2(tasks, times, dependencies);
        assertEquals(101, result);
    }
}