package com.connor.leeteasy;

public class MoveZeros {
    public static void moveZeroes(int[] nums) {
        int l = 0, r = 1;
        while(r < nums.length){
            if(nums[r] == 0 || l>=r){
                r++;
                continue;
            }
            if(nums[l] == 0){
                nums[l] = nums[r];
                nums[r] = 0;
            }
            l++;
        }
    }
}
