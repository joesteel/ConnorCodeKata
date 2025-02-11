package com.connor.leeteasy;

import java.util.Arrays;

public class ArrayPairsSum {

    public static int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int result = 0;
        for(int i = 0; i < nums.length; i++){
            if(i%2 == 0) result += nums[i];
        }
        return result;
    }
}
