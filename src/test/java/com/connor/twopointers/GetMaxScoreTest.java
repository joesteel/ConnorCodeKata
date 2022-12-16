package com.connor.twopointers;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GetMaxScoreTest {

    @Test
    void shouldGetMaxScoreForEmptyArrays() {
        List<Integer> a1 = new ArrayList<>();
        List<Integer> a2 = new ArrayList<>();
        int result = GetMaxScore.maximumScore(a1, a2);
        assertEquals(0, result);
    }

    @Test
    void shouldGetMaxScoreForArraysOfEqualSize_NoCrossOver() {
        List<Integer> a1 = new ArrayList<>(Arrays.asList(10,11,12));
        List<Integer> a2 = new ArrayList<>(Arrays.asList(1,2,3));
        int result = GetMaxScore.maximumScore(a1, a2);
        assertEquals(a1.stream().reduce(0, (x,y)->(x+y)), result);
    }

    @Test
    void shouldGetMaxScoreForArraysOfDiffSize_OneCrossOver() {
        List<Integer> a1 = new ArrayList<>(Arrays.asList(1,2,3,4));
        List<Integer> a2 = new ArrayList<>(Arrays.asList(3,5));
        int result = GetMaxScore.maximumScore(a1, a2);
        assertEquals(1+2+3+5, result);
    }

    @Test
    void shouldGetMaxScoreForArraysOfDiffSize_TwoCrossOver() {
        List<Integer> a1 = new ArrayList<>(Arrays.asList(2, 4, 5, 8, 10));
        List<Integer> a2 = new ArrayList<>(Arrays.asList(4, 6, 8, 9));
        int result = GetMaxScore.maximumScore(a1, a2);
        assertEquals(30, result);
    }

}