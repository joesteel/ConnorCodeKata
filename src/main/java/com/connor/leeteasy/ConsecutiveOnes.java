package com.connor.leeteasy;

public class ConsecutiveOnes {
    public static int findMaxConsecutiveOnes(int[] nums) {
       int l = 0, r = 0, max = 0;
       while(l < nums.length){
           if(nums[l] == 0) {
               l++;
               r = l;
           } else {
               while( r < nums.length && nums[r] == 1)
                   r++;
               max = Math.max(max, r-l);
               l = r;
           }
       }
        return max;
    }
}
