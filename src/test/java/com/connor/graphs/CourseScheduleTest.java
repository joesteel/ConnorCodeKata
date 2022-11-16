package com.connor.graphs;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class CourseScheduleTest {

    @Test
    void shouldCreateGraphCorrectly() {
        int n = 3;
        List<List<Integer>> pairs = new ArrayList<>(Arrays.asList(
                Arrays.asList(0,1),
                Arrays.asList(1,2),
                Arrays.asList(0,2)
        ));
        Map<Integer, List<Integer>> graph = CourseSchedule.createGraph(n, pairs);
        assertEquals(3, graph.keySet().size());
        assertTrue(graph.get(0).equals(Arrays.asList(1,2)));
        assertTrue(graph.get(1).equals(Arrays.asList(2)));
        assertTrue(graph.get(2).equals(Arrays.asList()));
    }

    @Test
    void shouldCountParentsCorrectly() {
        int n = 3;
        List<List<Integer>> pairs = new ArrayList<>(Arrays.asList(
                Arrays.asList(0,1),
                Arrays.asList(1,2),
                Arrays.asList(0,2)
        ));
        Map<Integer, List<Integer>> graph = CourseSchedule.createGraph(n, pairs);
        Map<Integer, Integer> parentCounts = CourseSchedule.countParents(graph);
        assertEquals(0, parentCounts.get(0));
        assertEquals(1, parentCounts.get(1));
        assertEquals(2, parentCounts.get(2));
    }


    @Test
    void shouldReturnTrueForOneNodeGraph() {
        int n = 1;
        List<List<Integer>> prerequisites = new ArrayList<>(Arrays.asList());
        boolean result = CourseSchedule.isValidCourseSchedule(n, prerequisites);
        assertTrue(result);
    }

    @Test
    void shouldReturnTrueForTwoNodeGraphWithNoCycles() {
        int n = 2;
        List<List<Integer>> prerequisites = new ArrayList<>(Arrays.asList(
                Arrays.asList(0,1)
        ));
        boolean result = CourseSchedule.isValidCourseSchedule(n, prerequisites);
        assertTrue(result);
    }

    @Test
    void shouldReturnFalseForTwoNodeGraphWithACycles() {
        int n = 2;
        List<List<Integer>> prerequisites = new ArrayList<>(Arrays.asList(
                Arrays.asList(0,1),
                Arrays.asList(1,0)
        ));
        boolean result = CourseSchedule.isValidCourseSchedule(n, prerequisites);
        assertFalse(result);
    }

    @Test
    void shouldReturnTrueForTwoNodeGraphWithNoCyclesAndMultipleEntryPoints() {
        int n = 4;
        List<List<Integer>> prerequisites = new ArrayList<>(Arrays.asList(
                Arrays.asList(0,1),
                Arrays.asList(1,2),
                Arrays.asList(0,2),
                Arrays.asList(3,2)
        ));
        boolean result = CourseSchedule.isValidCourseSchedule(n, prerequisites);
        assertTrue(result);
    }

}