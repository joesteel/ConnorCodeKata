package com.connor.dynamicprogramming;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PartitionIntoTwoEqualSumSubsetsTest {

    public static final int BOTTOM_UP = 1;

    @Test
    void shouldReturnFalseForEmptyList() {
        List<Integer> nums = new ArrayList<>();
        boolean result = PartitionIntoTwoEqualSumSubsets.canPartition(nums);
        assertFalse(result);
    }

    @Test
    void shouldReturnFalseFor2ElementListWhich() {
        List<Integer> nums = new ArrayList<>(Arrays.asList(1,1));
        boolean result = PartitionIntoTwoEqualSumSubsets.canPartition(nums);
        assertTrue(result);
    }

    @Test
    void shouldReturnFalseFor3ElementListWhich() {
        List<Integer> nums = new ArrayList<>(Arrays.asList(1,2,3));
        boolean result = PartitionIntoTwoEqualSumSubsets.canPartition(nums);
        assertTrue(result);
    }

    @Test
    void shouldReturnFalseForListWhichCanNotBePartitionedIntoEqualSums() {
        List<Integer> nums = new ArrayList<>(Arrays.asList(1,3,5));
        boolean result = PartitionIntoTwoEqualSumSubsets.canPartition(nums);
        assertFalse(result);
    }


    @Test
    void shouldReturnFalseForEmptyList_bo() {
        List<Integer> nums = new ArrayList<>();
        boolean result = PartitionIntoTwoEqualSumSubsets.canPartition(nums, BOTTOM_UP);
        assertFalse(result);
    }

    @Test
    void shouldReturnFalseFor2ElementListWhich_bo() {
        List<Integer> nums = new ArrayList<>(Arrays.asList(1,1));
        boolean result = PartitionIntoTwoEqualSumSubsets.canPartition(nums, BOTTOM_UP);
        assertTrue(result);
    }

    @Test
    void shouldReturnFalseFor3ElementListWhich_bo() {
        List<Integer> nums = new ArrayList<>(Arrays.asList(1,2,3));
        boolean result = PartitionIntoTwoEqualSumSubsets.canPartition(nums, BOTTOM_UP);
        assertTrue(result);
    }

    @Test
    void shouldReturnFalseForListWhichCanNotBePartitionedIntoEqualSums_bo() {
        List<Integer> nums = new ArrayList<>(Arrays.asList(1,3,5));
        boolean result = PartitionIntoTwoEqualSumSubsets.canPartition(nums,BOTTOM_UP);
        assertFalse(result);
    }

    @Test
    void shouldReturnFalseForListOfZeroes_bo() {
        List<Integer> nums = new ArrayList<>(Arrays.asList(0,0,0,0));
        boolean result = PartitionIntoTwoEqualSumSubsets.canPartition(nums,BOTTOM_UP);
        assertTrue(result);
    }

}