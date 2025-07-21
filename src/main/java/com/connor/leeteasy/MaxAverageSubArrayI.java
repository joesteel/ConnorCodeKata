package com.connor.leeteasy;

public class MaxAverageSubArrayI {
    public static double findMaxAverage(int[] nums, int k) {
        int ptr = 0;
        double sum = 0;
        while(ptr < k) sum += nums[ptr++];
        double maxSum = sum/k;
        while(ptr < nums.length){
            sum -= nums[ptr-k];
            sum += nums[ptr++];
            maxSum = Math.max(maxSum, sum/k);
        }
        return maxSum;
    }
}
