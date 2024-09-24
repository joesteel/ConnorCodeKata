package com.connor.leeteasy;

import java.util.ArrayList;
import java.util.List;

public class DisappearedNumbers {
    public static List<Integer> disappearedNumbers(int[] nums) {
        for (int i = 0; i < nums.length; ) {
            int index_num_should_be_in = nums[i]-1;
            if (nums[i] == nums[index_num_should_be_in] || nums[i] == i+1) i++;
            else {
                int temp = nums[index_num_should_be_in];
                nums[index_num_should_be_in] = nums[i];
                nums[i] = temp;
            }
        }
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i<nums.length;i++){
            if(nums[i] != i+1) result.add(i+1);
        }
        return result;
    }

}
