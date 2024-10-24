package com.connor.leeteasy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NextGreaterElementITest {

    @Test
    void shouldDetectNextGreatestNumbers() {
        int[] result = NextGreaterElementI.nextGreaterElement(new int[]{2,1}, new int[]{1,3,2});
        assertArrayEquals(new int[]{-1, 3}, result);
        assertArrayEquals(new int[]{-1, 3}, NextGreaterElementI.nextGreaterElementUsingMonotonicStack(new int[]{2,1}, new int[]{1,3,2}));
    }

    @Test
    void shouldDetectNextGreatestNumbers2() {
        int[] result = NextGreaterElementI.nextGreaterElement(new int[]{4,2,1}, new int[]{1,5,2,0,4});
        assertArrayEquals(new int[]{-1,4,5}, result);
        assertArrayEquals(new int[]{-1,4,5}, NextGreaterElementI.nextGreaterElementUsingMonotonicStack(new int[]{4,2,1}, new int[]{1,5,2,0,4}));

    }

}