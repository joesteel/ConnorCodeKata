package com.connor.twopointers;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class TrappingRainWaterTest {

    @Test
    void shouldReturnZeroWhenEmptyList() {
        List<Integer> elevations = new ArrayList<>();
        int result = TrappingRainWater.trappingRainWater(elevations);
        assertEquals(0, result);
    }

    @Test
    void shouldReturnZeroWhenNoTraps() {
        List<Integer> elevations = new ArrayList<>(Arrays.asList(1,1,1));
        int result = TrappingRainWater.trappingRainWater(elevations);
        assertEquals(0, result);
    }

    @Test
    void shouldReturnCorrectResultWhenOneSimpleTrap() {
        List<Integer> elevations = new ArrayList<>(Arrays.asList(1,0,1));
        int result = TrappingRainWater.trappingRainWater(elevations);
        assertEquals(1, result);
    }

    @Test
    void shouldReturnCorrectResultWhenOneTieredTrap() {
        List<Integer> elevations = new ArrayList<>(Arrays.asList(0,3,2,1,0,2,3,2));
        int result = TrappingRainWater.trappingRainWater(elevations);
        assertEquals(7, result);
    }

    @Test
    void shouldReturnCorrectResultWhenTwoSimpleTrap() {
        List<Integer> elevations = new ArrayList<>(Arrays.asList(2,1,2,0,2));
        int result = TrappingRainWater.trappingRainWater(elevations);
        assertEquals(3, result);
    }

    @Test
    void shouldDealWithAPeakAtTheStart() {
        List<Integer> elevations = new ArrayList<>(Arrays.asList(5,2,1,2));
        int result = TrappingRainWater.trappingRainWater(elevations);
        assertEquals(1, result);
    }

    @Test
    void shouldDealWithAPeakAtTheEnd() {
        List<Integer> elevations = new ArrayList<>(Arrays.asList(2,1,2,10));
        int result = TrappingRainWater.trappingRainWater(elevations);
        assertEquals(1, result);
    }

    @Test
    void shouldDealWithAPeakInTheMiddle() {
        List<Integer> elevations = new ArrayList<>(Arrays.asList(0,3,2,1,6,2,0,2));
        int result = TrappingRainWater.trappingRainWater(elevations);
        assertEquals(5, result);
    }

    @Test
    void someHardTestIDontUnderstand() {
        String input =  "4 0 2 3";
        List<Integer> elevations = Arrays.stream(input.split(" ")).map(s->Integer.valueOf(s)).collect(Collectors.toList());
        int result = TrappingRainWater.trappingRainWater(elevations);
        assertEquals(3+1, result);
    }
}