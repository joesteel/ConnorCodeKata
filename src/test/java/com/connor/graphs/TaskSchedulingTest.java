package com.connor.graphs;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class TaskSchedulingTest {

    @Test
    void shouldCreateGraphMapFromRequirementsList() {
        List<String> vertices = new ArrayList<>(Arrays.asList("a", "b", "c", "d"));
        List<List<String>> dependencies = new ArrayList<>(
                Arrays.asList(Arrays.asList("a", "b", "c"),
                Arrays.asList("b", "c"),
                Arrays.asList("c", "d")
                ));
        Map<String, List<String>> result = TaskScheduling.createMap(vertices, dependencies);
        assertTrue(result.get("a").equals(Arrays.asList("b", "c")));
        assertTrue(result.get("b").equals(Arrays.asList("c")));
        assertTrue(result.get("c").equals(Arrays.asList("d")));
        assertTrue(result.get("d").equals(Arrays.asList()));
        assertTrue(result.keySet().size() == 4);
    }

    @Test
    void shouldInitializeParentCountsCorrectlyBaseCase() {
        List<String> vertices = new ArrayList<>(Arrays.asList("a", "b", "c", "d", "e"));
        List<List<String>> dependencies = new ArrayList<>(
                Arrays.asList(Arrays.asList("a", "b", "c"),
                Arrays.asList("b", "c"),
                Arrays.asList("c", "d")
                ));
        Map<String, Integer> counts = TaskScheduling.initializeCounts(TaskScheduling.createMap(vertices, dependencies));
        assertEquals(0, counts.get("a"));
        assertEquals(1, counts.get("b"));
        assertEquals(2, counts.get("c"));
        assertEquals(1, counts.get("d"));
        assertEquals(0, counts.get("e"));
        assertTrue(counts.keySet().size() == vertices.size());
    }


    @Test
    void shouldInitializeParentCountsCorrectlyComplexCase() {
        List<String> vertices = new ArrayList<>(Arrays.asList("a", "b", "c", "d"));
        List<List<String>> dependencies = new ArrayList<>(
                Arrays.asList(Arrays.asList("a", "b"))
        );
        Map<String, Integer> counts = TaskScheduling.initializeCounts(TaskScheduling.createMap(vertices, dependencies));
        assertEquals(0, counts.get("a"));
        assertEquals(1, counts.get("b"));
    }

    @Test
    void shouldRunTasksInTopologicalOrderBaseCase() {
        List<String> tasks = new ArrayList<>(Arrays.asList("a", "b"));
        List<List<String>> dependencies = new ArrayList<>(
                Arrays.asList(Arrays.asList("a", "b"))
        );
        List<String> result = TaskScheduling.taskScheduling(tasks, dependencies);
        assertEquals(2, result.size());
        assertTrue(result.equals(Arrays.asList("a", "b")));
    }

    @Test
    void shouldReturnNullIfDAGContainsACycle() {
        List<String> tasks = new ArrayList<>(Arrays.asList("a", "b"));
        List<List<String>> dependencies = new ArrayList<>(
                Arrays.asList(
                        Arrays.asList("a", "b"),
                        Arrays.asList("b", "a")
                )
        );
        List<String> result = TaskScheduling.taskScheduling(tasks, dependencies);
        assertTrue(result == null);
    }

    @Test
    void shouldRunTasksInTopologicalOrder_4Tasks3Dependencies() {
        List<String> tasks = new ArrayList<>(Arrays.asList("a", "b", "c", "d"));
        List<List<String>> dependencies = new ArrayList<>(
                Arrays.asList(
                        Arrays.asList("a", "b"),
                        Arrays.asList("c", "b"),
                        Arrays.asList("b", "d")
                )
        );
        List<String> result = TaskScheduling.taskScheduling(tasks, dependencies);
        assertEquals(4, result.size());
        assertTrue(result.equals(Arrays.asList("a", "c", "b", "d")));
    }

}