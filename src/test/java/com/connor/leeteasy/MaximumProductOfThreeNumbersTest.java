package com.connor.leeteasy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaximumProductOfThreeNumbersTest {

    @Test
    void shouldComputeMaxProductFromThree() {
        assertEquals(-6, MaximumProductOfThreeNumbers.maximumProduct(new int[]{-1,-2,-3,-4}));
        assertEquals(0, MaximumProductOfThreeNumbers.maximumProduct(new int[]{-1,0,1,2}));
        assertEquals(0, MaximumProductOfThreeNumbers.maximumProduct(new int[]{-1,0,1}));
        assertEquals(600, MaximumProductOfThreeNumbers.maximumProduct(new int[]{-100,-2, 3,2,1}));
        assertEquals(6, MaximumProductOfThreeNumbers.maximumProduct(new int[]{-1, 3,2,1}));
        assertEquals(6, MaximumProductOfThreeNumbers.maximumProduct(new int[]{3,2,1}));
        assertEquals(6, MaximumProductOfThreeNumbers.maximumProduct(new int[]{-1,1,2,3}));
        assertEquals(6, MaximumProductOfThreeNumbers.maximumProduct(new int[]{1,2,3}));
    }
}