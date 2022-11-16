package com.connor.graphs;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ReconstructingSequenceTest {

    @Test
    void shouldCreateGraphFromSequences_Basic() {
        List<Integer> original = new ArrayList<>(Arrays.asList(1,2,3));
        List<List<Integer>> seqs = new ArrayList<>(
                Arrays.asList(
                        Arrays.asList(1,2),
                        Arrays.asList(1,3)
                )
        );
        Map<Integer, List<Integer>> graph = ReconstructingSequence.createGraph(original, seqs);
        assertTrue(graph.get(1).equals(Arrays.asList(2,3)));
        assertTrue(graph.get(2).equals(Arrays.asList()));
        assertTrue(graph.get(3).equals(Arrays.asList()));
        assertEquals(3, graph.size());
    }

    @Test
    void shouldCreateGraphFromSequences_Complex() {
        List<Integer> original = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7));
        List<List<Integer>> seqs = new ArrayList<>(
                Arrays.asList(
                        Arrays.asList(1,2),
                        Arrays.asList(2,3,4,5,6),
                        Arrays.asList(5,7)
                        )
        );
        Map<Integer, List<Integer>> graph = ReconstructingSequence.createGraph(original, seqs);
        assertTrue(graph.get(1).equals(Arrays.asList(2)));
        assertTrue(graph.get(2).equals(Arrays.asList(3)));
        assertTrue(graph.get(3).equals(Arrays.asList(4)));
        assertTrue(graph.get(4).equals(Arrays.asList(5)));
        assertTrue(graph.get(5).equals(Arrays.asList(6,7)));
        assertTrue(graph.get(6).equals(Arrays.asList()));
        assertTrue(graph.get(7).equals(Arrays.asList()));
        assertEquals(7, graph.size());
    }

    @Test
    void shouldDetectSimpleTrueSequence() {
        List<Integer> original = new ArrayList<>(Arrays.asList(1,2,3));
        List<List<Integer>> seqs = new ArrayList<>(
                Arrays.asList(
                        Arrays.asList(1,2),
                        Arrays.asList(2,3)
                )
        );
        assertTrue(ReconstructingSequence.sequenceReconstruction(original, seqs));
    }

    @Test
    void shouldDetectSimpleFalseSequence() {
        List<Integer> original = new ArrayList<>(Arrays.asList(1,2,3));
        List<List<Integer>> seqs = new ArrayList<>(
                Arrays.asList(
                        Arrays.asList(1,2),
                        Arrays.asList(1,3)
                )
        );
        assertFalse(ReconstructingSequence.sequenceReconstruction(original, seqs));
    }

    @Test
    void shouldDetectLongerSequence() {
        List<Integer> original = new ArrayList<>(Arrays.asList(1,2,3));
        List<List<Integer>> seqs = new ArrayList<>(
                Arrays.asList(
                        Arrays.asList(1,2),
                        Arrays.asList(2,3),
                        Arrays.asList(1,3)
                )
        );
        assertTrue(ReconstructingSequence.sequenceReconstruction(original, seqs));
    }

    @Test
    void shouldDetectLongerErSequence() {
        List<Integer> original = new ArrayList<>(Arrays.asList(4,1,5,2,6,3));
        List<List<Integer>> seqs = new ArrayList<>(
                Arrays.asList(
                        Arrays.asList(5,2,6,3),
                        Arrays.asList(4,1,5,2)
                )
        );
        assertTrue(ReconstructingSequence.sequenceReconstruction(original, seqs));
    }

}