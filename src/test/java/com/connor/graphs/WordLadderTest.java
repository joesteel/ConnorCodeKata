package com.connor.graphs;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class WordLadderTest {

    @Test
    void shouldBuildAdjacencyList() {
        List<List<String>> adjacencyList = WordLadder.buildAdjacencyList(Arrays.asList("abc","xyz"));
        assertTrue(adjacencyList.get(0).equals(Arrays.asList("a", "x")));
        assertTrue(adjacencyList.get(1).equals(Arrays.asList("b", "y")));
        assertTrue(adjacencyList.get(2).equals(Arrays.asList("c", "z")));
    }

    @Test
    void shouldBuildAdjacencyListWithNoDuplicates() {
        List<List<String>> adjacencyList = WordLadder.buildAdjacencyList(Arrays.asList("abc","xyc"));
        assertTrue(adjacencyList.get(0).equals(Arrays.asList("a", "x")));
        assertTrue(adjacencyList.get(1).equals(Arrays.asList("b", "y")));
        assertTrue(adjacencyList.get(2).equals(Arrays.asList("c")));
    }

    @Test
    void shouldGetNeighboursUsingAdjacencyList() {
        String word = "ab";
        List<String> allowedWords = new ArrayList<>(Arrays.asList("ab", "bb", "bc", "ad"));
        List<List<String>>  adjacencyList = WordLadder.buildAdjacencyList(allowedWords);
        List<String> neighbours = WordLadder.getNeighbours(word, adjacencyList, allowedWords);
        assertTrue(neighbours.get(0).equals("bb"));
        assertTrue(neighbours.get(1).equals("ad"));
    }

    @Test
    void shouldGetNeighboursUsingAdjacencyList2() {
        String word = "lost";
        List<String> allowedWords = new ArrayList<>(Arrays.asList("cost", "cast"));
        List<List<String>>  adjacencyList = WordLadder.buildAdjacencyList(allowedWords);
        List<String> neighbours = WordLadder.getNeighbours(word, adjacencyList, allowedWords);
        assertEquals(1, neighbours.size());
        String result1 = neighbours.get(0);
        assertTrue(result1.equals("cost"));
        neighbours = WordLadder.getNeighbours(result1, adjacencyList, allowedWords);
        assertEquals(1, neighbours.size());
        String result2= neighbours.get(0);
        assertTrue(result2.equals("cast"));
    }

    @Test
    void shouldReturnWordLadderForWordListWithAGapOfOne() {
        String word = "lost";
        List<String> allowedWords = new ArrayList<>(Arrays.asList("lost", "cost", "cast"));
        int result = WordLadder.wordLadder("lost", "cost", allowedWords);
        assertEquals(1, result);
    }

    @Test
    void shouldReturnWordLadderForWordListWithAGapOfTwo() {
        String word = "lost";
        List<String> allowedWords = new ArrayList<>(Arrays.asList("lost", "cost", "cast"));
        int result = WordLadder.wordLadder("lost", "cast", allowedWords);
        assertEquals(2, result);
    }

    @Test
    void shouldReturnWordLadderForWordListWithAGapOfThree() {
        String word = "lost";
        List<String> allowedWords = new ArrayList<>(Arrays.asList("lost", "cost", "cast", "case"));
        int result = WordLadder.wordLadder("lost", "case", allowedWords);
        assertEquals(3, result);
    }

    @Test
    void shouldReturnNotFoundWhenNoPathToTarget() {
        String word = "lost";
        List<String> allowedWords = new ArrayList<>(Arrays.asList("lost", "haha", "ohoh", "shit", "lolz"));
        int result = WordLadder.wordLadder("lost", "lolz", allowedWords);
        assertEquals(-1, result);
    }
}
