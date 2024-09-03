package com.connor.leeteasy;

public class ThirdMax {

    public static int thirdMax(int[] nums) {
        Integer max = nums[0], second_max = null, third_max = null;
        for(int num: nums){
            if(num > max) {
                if(second_max != null) third_max = second_max;
                second_max = max;
                max = num;
            }
            if(num < max && second_max == null){
                second_max = num;
            } else if (num < max && num > second_max) {
                third_max = second_max;
                second_max = num;
            }
            if(second_max != null && num < second_max && third_max == null || second_max != null && num < second_max && num > third_max)
                third_max = num;
        }
        if(third_max == null) third_max = max;
        return third_max;
    }
}
