package com.connor.leeteasy;

public class RemoveDuplicatesFromSortedArray {
    public static int removeDuplicates(int[] nums) {
        int lPtr = 0, rPtr = 1;
        while(rPtr < nums.length){
            if(nums[rPtr] == nums[lPtr]){
                rPtr++;
            } else{
                lPtr++;
                nums[lPtr] = nums[rPtr];
            }
        }
        return lPtr+1;
    }
}