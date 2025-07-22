package com.connor.leetmedium;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NextPermutationTest {

    @Test
    void shouldReturnNextPerm_1() {
        int[] nums = {1,2,3,4};
        int[] expected = {1,2,4,3};
        NextPermutation.nextPermutation(nums);
        assertArrayEquals(expected, nums);
    }

    @Test
    void shouldReturnNextPerm_2() {
        int[] nums = {1,3,2};
        int[] expected = {2,1,3};
        NextPermutation.nextPermutation(nums);
        assertArrayEquals(expected, nums);
    }

    @Test
    void shouldReturnNextPerm_3() {
        int[] nums = {0,1,3,2};
        int[] expected = {0,2,1,3};
        NextPermutation.nextPermutation(nums);
        assertArrayEquals(expected, nums);
    }

    @Test
    void shouldReturnNextPerm_4() {
        int[] nums = {2,3,1};
        int[] expected = {3,1,2}; // wtf is going on here
        NextPermutation.nextPermutation(nums);
        assertArrayEquals(expected, nums);
    }

    @Test
    void shouldReturnNextPerm_5() {
        int[] nums = {5,4,7,5,3,2};
        int[] expected = {5,5,2,3,4,7}; // wtf is going on here
        NextPermutation.nextPermutation(nums);
        assertArrayEquals(expected, nums);
    }
//
@Test
void shouldReturnNextPerm_6() {
    int[] nums = {4,2,0,2,3,2,0};
    int[] expected = {4,2,0,3,0,2,2};
    // ok so my algo doesn't work here... I went too far down the list 2vs0
    // when I had an option to pull and earlier swap ie 2vs3
    // so the inner loop should terminate as soon as spot an earlier swap?
    NextPermutation.nextPermutation(nums);
    assertArrayEquals(expected, nums);
}


    @Test
    void shouldReturnNextPerm_7() {
        int[] nums = {2,2,7,5,4,3,2,2,1};
        int[] expected = {2,3,1,2,2,2,4,5,7};
        // ok so my algo doesn't work here...
        // I'm checking 3 and get down as far as 2,7 !
        // at this point it breaks... but actually in this case it should swap the 3 with the 2
        NextPermutation.nextPermutation(nums);
        assertArrayEquals(expected, nums);
    }

    @Test
    void shouldPerformFullReOrdering() {
        int[] nums = {4,3,2,1};
        int[] expected = {1,2,3,4};
        NextPermutation.nextPermutation(nums);
        assertArrayEquals(expected, nums);
    }
}