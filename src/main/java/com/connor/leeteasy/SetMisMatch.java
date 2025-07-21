package com.connor.leeteasy;

public class SetMisMatch {

    public static int[] findErrorNums(int[] nums) {
        int expected = nums.length * (nums.length + 1) / 2;
        boolean[] state = new boolean[nums.length+1];
        int[] result = new int[2];
        int sum = 0;

        for(int n: nums){
            if(state[n]){
                result[0] = n;
            }
            state[n] = true;
            sum += n;
        }
        result[1] = expected - (sum - result[0]);
        return result;
    }
}
