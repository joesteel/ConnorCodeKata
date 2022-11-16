package com.connor.graphs;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CourseScheduleWithStatesTest {

    @Test
    void shouldReturnTrueForOneNodeGraph() {
        int n = 1;
        List<List<Integer>> prerequisites = new ArrayList<>(Arrays.asList());
        boolean result = CourseScheduleWithStates.isValidCourseSchedule(n, prerequisites);
        assertTrue(result);
    }

    @Test
    void shouldReturnTrueForTwoNodeGraphWithNoCycles() {
        int n = 2;
        List<List<Integer>> prerequisites = new ArrayList<>(Arrays.asList(
                Arrays.asList(0,1)
        ));
        boolean result = CourseScheduleWithStates.isValidCourseSchedule(n, prerequisites);
        assertTrue(result);
    }

    @Test
    void shouldReturnFalseForTwoNodeGraphWithACycles() {
        int n = 2;
        List<List<Integer>> prerequisites = new ArrayList<>(Arrays.asList(
                Arrays.asList(0,1),
                Arrays.asList(1,0)
        ));
        boolean result = CourseScheduleWithStates.isValidCourseSchedule(n, prerequisites);
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
        boolean result = CourseScheduleWithStates.isValidCourseSchedule(n, prerequisites);
        assertTrue(result);
    }
}