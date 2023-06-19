package com.connor.dynamicprogramming;

import java.util.Arrays;
import java.util.List;

public class LongestSubsequence {

    public static int longestSubLen(List<Integer> nums) {

        return 0;
    }

    public static int longestSubLenTD(List<Integer> nums) {
        return dfs(nums, -1, 0, 0);
    }

    public static int dfs(List<Integer> nums, int lastUsedNum, int currentLevel, int subsequenceCount) {
        if (currentLevel == nums.size()) return subsequenceCount;
        int left = 0;
        if (nums.get(currentLevel) > lastUsedNum) {
            left = dfs(nums, nums.get(currentLevel), currentLevel + 1, subsequenceCount + 1);
        }
        int right = dfs(nums, lastUsedNum, currentLevel + 1, subsequenceCount);
        return Math.max(left, right);
    }

}
