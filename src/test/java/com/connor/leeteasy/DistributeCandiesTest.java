package com.connor.leeteasy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DistributeCandiesTest {

    @Test
    void shouldDistributeCandies() {
        assertEquals(1, DistributeCandies.distributeCandies(new int[]{1,1,1,1,1,1}));
        assertEquals(3, DistributeCandies.distributeCandies(new int[]{1,1,2,3,4,5,6}));
        assertEquals(4, DistributeCandies.distributeCandies(new int[]{1,1,1,2,3,4,5,6}));
        assertEquals(3, DistributeCandies.distributeCandies(new int[]{1,2,3,1,2,3}));
    }
}