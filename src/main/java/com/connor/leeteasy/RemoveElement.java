package com.connor.leeteasy;

public class RemoveElement {
    public static int removeElement(int[] nums, int val) {
        int new_length = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != val) {
                nums[new_length] = nums[i];
                new_length++;
            }
        }
    return new_length;
    }
}
