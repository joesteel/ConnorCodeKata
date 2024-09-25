package com.connor.leeteasy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AssignCookiesTest {
    @Test
    void shouldAssignCookies_SortedInputs_NotEnoughCookie_Mass() {
        int[] greed = new int[]{1,2,3};
        int[] cookie_sizes = new int[]{1,1,1};
        int result = AssignCookies.findContentChildren(greed, cookie_sizes);
        assertEquals(2, result);
    }

    @Test
    void shouldAssignCookies_UnSortedInputs_NotEnoughCookie_Mass() {
        int[] greed = new int[]{3,2,1};
        int[] cookie_sizes = new int[]{1,1,1};
        int result = AssignCookies.findContentChildren(greed, cookie_sizes);
        assertEquals(2, result);
    }

    @Test
    void shouldAssignCookies_SortedInputs_NotEnoughCookies_Units() {
        int[] greed = new int[]{1,2,3};
        int[] cookie_sizes = new int[]{10};
        int result = AssignCookies.findContentChildren(greed, cookie_sizes);
        assertEquals(1, result);
    }

    @Test
    void shouldAssignCookies_UnSortedInputs_NotEnoughCookies_Units() {
        int[] greed = new int[]{5,2,3};
        int[] cookie_sizes = new int[]{10};
        int result = AssignCookies.findContentChildren(greed, cookie_sizes);
        assertEquals(1, result);
    }

    @Test
    void shouldAssignCookies_SortedInputs_EnoughCookies() {
        int[] greed = new int[]{1,2,3};
        int[] cookie_sizes = new int[]{4,5,10};
        int result = AssignCookies.findContentChildren(greed, cookie_sizes);
        assertEquals(3, result);
    }


    @Test
    void shouldAssignCookies_UnSortedInputs_EnoughCookies() {
        int[] greed = new int[]{2,3,1};
        int[] cookie_sizes = new int[]{2,1,3};
        int result = AssignCookies.findContentChildren(greed, cookie_sizes);
        assertEquals(3, result);
    }
}