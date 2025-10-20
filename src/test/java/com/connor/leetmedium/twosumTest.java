package com.connor.leetmedium;

import com.connor.leeteasy.TwoSum;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TwoSumTest {
    @Test
    void shouldFindTwoSum() {
        assertArrayEquals(new int[]{1,2}, TwoSum.twoSum(new int[]{3,2,4}, 6));
        assertArrayEquals(new int[]{0,1}, TwoSum.twoSum(new int[]{2,4,11,3}, 6));
    }
}