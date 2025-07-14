package com.connor.leetmedium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for(int a = 0; a <= nums.length-4; a++){
            if(a > 0 && nums[a] == nums[a-1]) continue;
            for(int b = a+1; b <= nums.length-3; b++){
              if(b > a+1 && nums[b] == nums[b-1]) continue;
              addResultIfTwoSumMatch(nums, target, a, b, result);
            }
        }
        return new ArrayList<>(result);
    }

    private static void addResultIfTwoSumMatch(int[] nums, int target, int a, int b, List<List<Integer>> result){
        int l = b+1;
        int r = nums.length-1;
        while(l < r) {
            long sum = (long)nums[l] + nums[b] + nums[r] + nums[a] ;
            if(sum == target){
                result.add(Arrays.asList(nums[a], nums[l], nums[r], nums[b]));
                while(l < r && nums[l] == nums[l+1]) l++;
                while(r > l && nums[r] == nums[r-1]) r--;
                l++;r--;
            }
            else if(sum > target) r--;
            else l++;
        }
    }
}
