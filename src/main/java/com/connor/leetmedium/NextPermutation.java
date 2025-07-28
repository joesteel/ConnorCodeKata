package com.connor.leetmedium;

public class NextPermutation {

    public static void nextPermutation(int[] nums) {
        boolean swaps = false;
        for(int i = nums.length-1; i >= 1 && !swaps; i--){
            for(int j = i-1; j >= 0; j--){
                if(nums[i] > nums[j]){
                    swap(i, j, nums);
                    swaps = true;
                    if(j < nums.length-1) sortAscending(j+1, nums.length-1, nums);
                    break;
                }
                if(j > 0 && nums[j+1] > nums[j])break;
            }
        }
        if(!swaps){
            int l = 0, r = nums.length-1;
            while(l < r){
                swap(l,r,nums);
                l++;r--;
            }
        }
    }

    private static void sortAscending(int start, int end, int[] nums){
        while(end > start) {
            for (int j = start; j < end; j++) {
                if (nums[j] > nums[end])
                    swap(j, end, nums);
            }
            end--;
        }
    }

    private static void swap(int i, int j, int[] nums){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
