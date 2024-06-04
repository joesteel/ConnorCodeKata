package com.connor.leeteasy;

import java.util.Arrays;

class NumArray {

    int[] nums;
    int[][] memo;

    public NumArray(int[] nums) {
        this.nums = nums;
        memo = new int[nums.length][nums.length];
        for (int[] array : memo) Arrays.fill(array, Integer.MIN_VALUE);
    }

    public int sumRange(int left, int right) {
        if(left > right) return 0;
        if(left == right) return nums[left];

        if(memo[left][right] > Integer.MIN_VALUE) return memo[left][right];
        int result = sumRange(left+1, right) + nums[left];
        memo[left][right] = result;

        return result;
    }
}