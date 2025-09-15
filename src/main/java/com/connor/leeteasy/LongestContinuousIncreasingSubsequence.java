package com.connor.leeteasy;

public class LongestContinuousIncreasingSubsequence {

    public static int findLengthOfLCIS(int[] nums) {
        int p1= 0, p2, max = 0;
        while(p1 < nums.length){
            for(p2 = p1+1; p2 < nums.length && (nums[p2-1] < nums[p2]); p2++) continue; // open window
            max = Math.max(p2-p1, max);
            p1 = p2; // reset window from end of old window
        }
        return max;
    }
}
