package com.connor.graphs;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OpenLockTest {

    @Test
    void shouldGetNeighboursCorrectlyForValsBelow9() {
        for(int i= 1; i < 8; i++){
            String combo = "" + i + i + i + i;
            List<String> neighbours = OpenLock.getNeighbours(combo);
            int newValUp = i+1;
            int newValDown = i-1;

            assertTrue(neighbours.equals(Arrays.asList(""+i+i+i+newValUp, ""+i+i+newValUp+i, ""+i+newValUp+i+i, ""+newValUp+i+i+i,
                    ""+i+i+i+newValDown, ""+i+i+newValDown+i, ""+i+newValDown+i+i, ""+newValDown+i+i+i)));
        }
    }

    @Test
    void shouldGetNeighboursCorrectlyFor9() {
        String combo = "9999";
        List<String> neighbours = OpenLock.getNeighbours(combo);
        int newVal = 0;
        assertTrue(neighbours.equals(Arrays.asList("9990", "9909", "9099", "0999", "9998", "9989", "9899", "8999")));
    }

    @Test
    void shouldGetNeighboursCorrectlyFor0() {
        String combo = "0000";
        List<String> neighbours = OpenLock.getNeighbours(combo);
        int newVal = 0;
        assertTrue(neighbours.equals(Arrays.asList("0001", "0010", "0100", "1000", "0009", "0090", "0900", "9000")));
    }

    @Test
    void shouldAlwaysTriggerTrapWhenTrapIs0000() {
        ArrayList<String> traps = new ArrayList<>(Arrays.asList("0000"));
        String targetCombo = "1111";
        assertEquals(-1, OpenLock.numSteps(targetCombo, traps));
    }

    @Test
    void shouldReturnTargetComboWhenOneLevelDown() {
        ArrayList<String> traps = new ArrayList<>(Arrays.asList("1111"));
        String targetCombo = "0001";
        assertEquals(1, OpenLock.numSteps(targetCombo, traps));
    }

    @Test
    void shouldReturnTargetComboWhenTwoLevelsDownAndOnePathIsBlocked() {
        ArrayList<String> traps = new ArrayList<>(Arrays.asList("1000"));
        String targetCombo = "1001";
        assertEquals(2, OpenLock.numSteps(targetCombo, traps));
    }

    @Test
    void shouldReturnTargetComboWhen2LevelsDownAndTwoPathsAreBlocked() {
        ArrayList<String> traps = new ArrayList<>(Arrays.asList("0001", "0200"));
        String targetCombo = "0201";
        assertEquals(3, OpenLock.numSteps(targetCombo, traps));
    }

    @Test
    void shouldReturnTargetComboWhenSixLevelsDown() {
        ArrayList<String> traps = new ArrayList<>(Arrays.asList("0201","0101","0102","1212","2002"));
        String targetCombo = "0202";
        assertEquals(6, OpenLock.numSteps(targetCombo, traps));
    }
}