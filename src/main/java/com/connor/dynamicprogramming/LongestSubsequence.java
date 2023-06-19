package com.connor.dynamicprogramming;

import java.util.Arrays;
import java.util.List;

public class LongestSubsequence {

    public static int longestSubLen(List<Integer> nums) {

        return 0;
    }

    public static int longestSubLenTD(List<Integer> nums) {
        int[] state = new int[nums.size()];
        Arrays.fill(state, Integer.MIN_VALUE);
        return dfs(nums, -1, 0, 0, state);
    }

    public static int dfs(List<Integer> nums, int lastUsedNum, int currentLevel, int subsequenceCount, int[] state) {
        if (currentLevel == nums.size()) return subsequenceCount;
        int left = 0;

        if(state[currentLevel] <= subsequenceCount) {
            if (nums.get(currentLevel) > lastUsedNum) {
                left = dfs(nums, nums.get(currentLevel), currentLevel + 1, subsequenceCount + 1, state);
                state[currentLevel] = subsequenceCount+1;
            }
        }
        int right = dfs(nums, lastUsedNum, currentLevel + 1, subsequenceCount, state);
        return Math.max(left, right);
    }

}
