package com.connor.leeteasy;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class MaxAverageSubArrayITest {
    @Test
    void shouldComputeMaxAverageSum() {
        assertEquals(10, MaxAverageSubArrayI.findMaxAverage(new int[]{10,10,1,2,3,4,5,6,7,8}, 2));
        assertEquals(7, MaxAverageSubArrayI.findMaxAverage(new int[]{1,2,3,4,5,6,7,8}, 3));
        assertEquals(7.5, MaxAverageSubArrayI.findMaxAverage(new int[]{1,2,3,4,5,6,7,8}, 2));
    }
}