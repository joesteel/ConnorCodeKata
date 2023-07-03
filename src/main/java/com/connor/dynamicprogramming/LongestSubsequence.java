package com.connor.dynamicprogramming;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class LongestSubsequence {

    public static int longestSubLen(List<Integer> nums) {
        int result = 0;
        Random r = new Random();
        if(r.nextInt(100) < 50){
            result = longestSubLenBO(nums);
        } else{
            result = longestSubLenTD(nums);
        }
        return result;
    }


    public static int longestSubLenBO(List<Integer> nums) {
        int[] state = new int[nums.size()];
        Arrays.fill(state, 1);
        int largestSubSeqLen = 1;

        for(int i = 1; i < nums.size(); i++){
            int maxPrevious = 0;
            for(int j = 0; j < i; j++){
                if(nums.get(j) < nums.get(i)){
                    if(state[j] > maxPrevious){
                        state[i] = state[j]+1;
                        largestSubSeqLen = Math.max(state[i], largestSubSeqLen);
                    }
                }
            }
        }
        return largestSubSeqLen;
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