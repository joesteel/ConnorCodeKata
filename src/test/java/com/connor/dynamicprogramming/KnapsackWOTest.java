package com.connor.dynamicprogramming;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

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
        assertEquals(2, result.size());
        assertEquals(0, result.get(0));
        assertEquals(1, result.get(1));
    }

    @Test
    void shouldReturnCorrectResultForKnapsackWith2DuplicateItems() {
        List<Integer> weights = new ArrayList<>(Arrays.asList(1,1));
        List<Integer> result = KnapsackWO.knapsackWeightOnly(weights);
        assertTrue(result.equals(Arrays.asList(0,1,2)));;
    }

    @Test
    void shouldReturnCorrectResultForKnapsackWith2Items() {
        List<Integer> weights = new ArrayList<>(Arrays.asList(1,2));
        List<Integer> result = KnapsackWO.knapsackWeightOnly(weights);
        assertEquals(4, result.size());
        Collections.sort(result);
        assertTrue(result.equals(Arrays.asList(0,1,2,3)));;
    }

    @Test
    void shouldReturnCorrectResultForKnapsackWithDuplicateItems() {
        List<Integer> weights = new ArrayList<>(Arrays.asList(1,2,2));
        List<Integer> result = KnapsackWO.knapsackWeightOnly(weights);
        assertEquals(6, result.size());
        Collections.sort(result);
        assertTrue(result.equals(Arrays.asList(0,1,2,3,4,5)));;
    }


    @Test
    void shouldReturnCorrectResultForKnapsackWithDuplicateItems_2() {
        List<Integer> weights = new ArrayList<>(Arrays.asList(1, 3, 3, 5));
        List<Integer> result = KnapsackWO.knapsackWeightOnly(weights);
        Collections.sort(result);
        assertTrue(result.equals(Arrays.asList(0, 1, 3, 4, 5, 6, 7, 8, 9, 11, 12)));
    }

    @Test
    void shouldReturnCorrectResultForKnapsackWithAll100s() {
        String input = "100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100";
        List<Integer> weights = Arrays.stream(input.split(" "))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());
        List<Integer> result = KnapsackWO.knapsackWeightOnly(weights);
        Collections.sort(result);
        String expectedResultsStr = "0 100 200 300 400 500 600 700 800 900 1000 1100 1200 1300 1400 1500 1600 1700 1800 1900 2000 2100 2200 2300 2400 2500 2600 2700 2800 2900 3000 3100 3200 3300 3400 3500 3600 3700 3800 3900 4000 4100 4200 4300 4400 4500 4600 4700 4800 4900 5000 5100 5200 5300 5400 5500 5600 5700 5800 5900 6000 6100 6200 6300 6400 6500 6600 6700 6800 6900 7000 7100 7200 7300 7400 7500 7600 7700 7800 7900 8000 8100 8200 8300 8400 8500 8600 8700 8800 8900 9000 9100 9200 9300 9400 9500 9600 9700 9800 9900 10000";
        List<Integer> expectedResultsList = Arrays.stream(expectedResultsStr.split(" ")).map(x->Integer.valueOf(x)).collect(Collectors.toList());
        assertTrue(result.equals(expectedResultsList));
    }


    @Test
    void shouldReturn0ForEmptyKnapsack_bo() {
        List<Integer> weights = new ArrayList<>();
        List<Integer> result = KnapsackWO.knapsackWeightOnly(weights, "bottom up");
        assertTrue(result.size() == 1);
        assertEquals(0, result.get(0));
    }

    @Test
    void shouldReturnCorrectResultForKnapsackWith1Item_bo() {
        List<Integer> weights = new ArrayList<>(Arrays.asList(1));
        List<Integer> result = KnapsackWO.knapsackWeightOnly(weights, "bottom up");
        assertEquals(2, result.size());
        assertEquals(0, result.get(0));
        assertEquals(1, result.get(1));
    }


    @Test
    void shouldReturnCorrectResultForKnapsackWith2DuplicateItems_bo() {
        List<Integer> weights = new ArrayList<>(Arrays.asList(1,1));
        List<Integer> result = KnapsackWO.knapsackWeightOnly(weights, "bottom up");
        assertTrue(result.equals(Arrays.asList(0,1,2)));;
    }

    @Test
    void shouldReturnCorrectResultForKnapsackWith2Items_bo() {
        List<Integer> weights = new ArrayList<>(Arrays.asList(1,2));
        List<Integer> result = KnapsackWO.knapsackWeightOnly(weights, "bottom up");
        assertEquals(4, result.size());
        Collections.sort(result);
        assertTrue(result.equals(Arrays.asList(0,1,2,3)));;
    }

    @Test
    void shouldReturnCorrectResultForKnapsackWithDuplicateItems_2_bo() {
        List<Integer> weights = new ArrayList<>(Arrays.asList(1, 3, 3, 5));
        List<Integer> result = KnapsackWO.knapsackWeightOnly(weights, "bottom up");
        Collections.sort(result);
        assertTrue(result.equals(Arrays.asList(0, 1, 3, 4, 5, 6, 7, 8, 9, 11, 12)));
    }


}