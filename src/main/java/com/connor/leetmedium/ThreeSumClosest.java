package com.connor.leetmedium;

import java.util.Arrays;

public class ThreeSumClosest {

    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        // todo need to guarantee a big distance between target and this starting value somehow
        int closest_three_sum = Math.abs(100000-target) > Math.abs(target + 100000) ? 100000 : -10000;
        for(int i = 0; i < nums.length - 2; i++){
            int l = i+1, r = nums.length-1;
            while(l < r){
                int sum = nums[i]+nums[l]+nums[r];
                if(Math.abs(target - sum) < Math.abs(target - closest_three_sum)) closest_three_sum = sum;
                if(target == sum){
                    return sum;
                } else if(target > sum) l++;
                else r--;
            }

        }
        return closest_three_sum;
    }
}
