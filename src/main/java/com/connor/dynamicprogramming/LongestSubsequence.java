package com.connor.dynamicprogramming;

import java.util.Arrays;
import java.util.List;

public class LongestSubsequence {

    public static int longestSubLen(List<Integer> nums) {

        return 0;
    }

    public static int longestSubLenTD(List<Integer> nums) {
        int[] state = new int[nums.size()];
        int result = 0;
        for(int i = 0; i < nums.size(); i++){
            result = Math.max(result, dfs(nums, i, state));
        }
        return result;
    }

    public static int dfs(List<Integer> nums, int position, int[] state) {
        if(position >= nums.size()-1) return 1;

        if(state[position] != 0) return state[position];
        int result = 0;
        for(int i = position+1; i < nums.size(); i++) {
            if(nums.get(i) > nums.get(position)) result = Math.max(result, dfs(nums, i, state));
        }
        result++;
        state[position] = result;
        return result;
    }

}
