package com.connor.dynamicprogramming;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LargestDivisibleSubset {
    public static int findLargestSubset(List<Integer> nums) {
        int[] memo = new int[nums.size()];
        Arrays.fill(memo, -1);
        Collections.sort(nums);
        int result = 0;
        for(int i = 0; i < nums.size(); i++) {
            int atomicResult = dfs(nums, i, memo);
            result = Math.max(atomicResult, result);
        }
        return result;
    }

    public static int dfs(List<Integer> nums, int index, int[] memo){
        if(index > nums.size()) return 0;
        if(memo[index] != -1) return memo[index];
        int result = 0;
        for(int i = index+1; i < nums.size(); i++) {
            if(nums.get(i)%nums.get(index) == 0) {
                result = Math.max(result, dfs(nums, i, memo));
            }
        }
        memo[index] = result+1;
        return result+1;
    }


}
