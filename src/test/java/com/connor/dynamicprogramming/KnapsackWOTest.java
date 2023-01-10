package com.connor.dynamicprogramming;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class KnapsackWOTest {
    @Test
    void shouldReturn0ForEmptyKnapsack() {
        List<Integer> weights = new ArrayList<>();
        List<Integer> result = KnapsackWO.knapsackWeightOnly(weights);
        assertTrue(result.size() == 1);
        assertEquals(0, result.get(0));
    }

    @Test
    void shouldReturnCorrectResultForKnapsackWith1Item() {
        List<Integer> weights = new ArrayList<>(Arrays.asList(1));
        List<Integer> result = KnapsackWO.knapsackWeightOnly(weights);
        assertTrue(result.size() == 2);
        assertEquals(0, result.get(0));
        assertEquals(1, result.get(1));
    }

    @Test
    void shouldReturnCorrectResultForKnapsackWith2Items() {
        List<Integer> weights = new ArrayList<>(Arrays.asList(1,2));
        List<Integer> result = KnapsackWO.knapsackWeightOnly(weights);
        assertTrue(result.size() == 4);
        assertTrue(result.equals(Arrays.asList(0,1,3,2)));;
    }

    @Test
    void shouldReturnCorrectResultForKnapsackWithDuplicateItems() {
    }

}