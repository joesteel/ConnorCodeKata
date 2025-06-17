package com.connor.leeteasy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CanGrowFlowersTest {

    @Test
    void shouldPlantFlowers() {
        assertEquals(true, CanGrowFlowers.canPlaceFlowers(new int[]{0,0,1,0,0}, 1));
        assertEquals(true, CanGrowFlowers.canPlaceFlowers(new int[]{0,0,1,0,0}, 2));
        assertEquals(true, CanGrowFlowers.canPlaceFlowers(new int[]{1,0,0,0,1}, 1));
        assertEquals(false, CanGrowFlowers.canPlaceFlowers(new int[]{1,0,0,0,1}, 2));
        assertEquals(false, CanGrowFlowers.canPlaceFlowers(new int[]{1,0,0,0}, 3));
        assertEquals(true, CanGrowFlowers.canPlaceFlowers(new int[]{1,0,0,0}, 1));
        assertEquals(true, CanGrowFlowers.canPlaceFlowers(new int[]{0,0,0,0}, 2));
        assertEquals(false, CanGrowFlowers.canPlaceFlowers(new int[]{0,0,0}, 3));
        assertEquals(true, CanGrowFlowers.canPlaceFlowers(new int[]{0,0,0}, 2));
    }
}