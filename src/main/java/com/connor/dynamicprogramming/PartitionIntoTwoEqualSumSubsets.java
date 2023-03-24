package com.connor.dynamicprogramming;

import java.util.List;

public class PartitionIntoTwoEqualSumSubsets {

    public static boolean canPartition(List<Integer> nums) {
        return canPartition(nums, 0);
    }

        public static boolean canPartition(List<Integer> nums, int type) {
        int total = nums.stream()
                .mapToInt(x->x)
                .sum();
        if (total % 2 != 0 || nums.size() == 0) {
            return false;
        }
        if(type == 0){
            return canPartitionTopDown(nums, total/2);
        } else {
            return  canPartitionBottomUp(nums, total/2);
        }
    }

    public static boolean canPartitionTopDown(List<Integer> nums, int target) {
        boolean[][] memo = new boolean[nums.size()][target];
        return subTreeContainsTarget(0, target, nums,  0, memo);
    }

    public static boolean subTreeContainsTarget(int level, int target, List<Integer> nums, int sum, boolean[][] memo){
        if(sum == target) return true;
        if (level == nums.size() || sum > target) return false;
        if(memo[level][sum]) return false;

        boolean left = subTreeContainsTarget(level+1, target, nums, sum+nums.get(level), memo);
        boolean right = subTreeContainsTarget(level+1, target, nums, sum, memo);

        if(!(left | right)) memo[level][sum] = true;
        return left | right;
    }


    public static boolean canPartitionBottomUp(List<Integer> nums, int target){
        boolean[][] stateSpace = new boolean[nums.size()+1][target+1];
        stateSpace[0][0] = true;

        for(int i=1;i<=nums.size();i++){
            for(int j = 0; j < target+1; j++){
                if(stateSpace[i-1][j]) {
                    stateSpace[i][j] = true;
                    int sum = j+nums.get(i-1);
                    if(sum == target) return true;
                    else if (sum > target) break;
                    else{
                        stateSpace[i][j+nums.get(i-1)] = true;
                    }
                }
            }
        }
        return false;
    }
}
