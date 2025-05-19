package com.connor.leetmedium;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ThreeSumClosestTest {

    @Test
    void shouldClosestThreeSum() {
        assertEquals(60, ThreeSumClosest.threeSumClosest(new int[]{10,20,30,40,50,60,70,80,90}, 1));
        assertEquals(-900, ThreeSumClosest.threeSumClosest(new int[]{0,100,100,-1000}, -10000));
        assertEquals(300, ThreeSumClosest.threeSumClosest(new int[]{0,100,100,100}, 10000));
        assertEquals(0, ThreeSumClosest.threeSumClosest(new int[]{0,0,0,0}, 1));
        assertEquals(2, ThreeSumClosest.threeSumClosest(new int[]{-1,2,1,-4}, 1));
    }
}