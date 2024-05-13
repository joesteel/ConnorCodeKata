package com.connor.leeteasy;

import java.util.Arrays;

public class MissingNumber {

    public static int missingNumber(int[] nums) {
        int[] sorted = new int[nums.length + 1];
        for(int x: nums){
            sorted[x] = 1;
        }
        for (int i = 0; i < sorted.length; i++){
            if(sorted[i] != 1) return i;
        }
        return -1;
    }

    public static int missingNumber2(int[] nums) {
        int total = (nums.length * (nums.length+1))/2;
        for (int n: nums){
            total -= n;
        }
        return total;
    }

}
