package com.connor.leeteasy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinIndexSumTest {
    @Test
    void shouldFindMinIndexSum() {
        assertArrayEquals(new String[]{"sad","happy"}, MinIndexSum.findRestaurant(
                new String[]{"happy","sad","good"},
                new String[]{"sad","happy","good"}
        ));
        assertArrayEquals(new String[]{"Shogun"}, MinIndexSum.findRestaurant(
                new String[]{"Shogun","Tapioca Express","Burger King","KFC"},
                new String[]{"KFC","Shogun","Burger King"}
        ));
        assertArrayEquals(new String[]{"Shogun"}, MinIndexSum.findRestaurant(
                new String[]{"Shogun","Tapioca Express","Burger King","KFC"},
                new String[]{"Piatti","The Grill at Torrey Pines","Hungry Hunter Steakhouse","Shogun"}
        ));
        assertArrayEquals(new String[]{"hello"}, MinIndexSum.findRestaurant(new String[]{"hello", "you"},new String[]{"hello"} ));

    }
}