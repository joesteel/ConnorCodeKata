package com.connor.leetmedium;

import java.util.*;

public class ThreeSum {

    public static List<List<Integer>> threeSum(int[] nums){
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for(int i = 0; i < nums.length - 2; i++){
            if(i > 0 && nums[i-1] == nums[i]) continue;

            int l = i+1, r = nums.length-1, target = nums[i] * -1;
            while(l < r){
                if(nums[l] + nums[r] == target){
                    result.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    while(l < r && nums[l+1] == nums[l]) l++;
                    while(l < r && nums[r-1] == nums[r]) r--;
                    l++;r--;
                } else if (nums[l] + nums[r] > target) r--;
                else l++;
            }
        }
        return result;
    }
}
