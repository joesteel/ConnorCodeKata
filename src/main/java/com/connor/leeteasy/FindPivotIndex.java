package com.connor.leeteasy;

import java.util.Arrays;

public class FindPivotIndex {

    public static int pivotIndex(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        int running_sum = 0;
        for(int i = 0; i < nums.length; i++) {
            if(running_sum == (sum - nums[i] - running_sum)) return i;
            running_sum += nums[i];
        }
        return -1;
    }
}
