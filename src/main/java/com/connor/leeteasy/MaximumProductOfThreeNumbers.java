package com.connor.leeteasy;

public class MaximumProductOfThreeNumbers {
    public static int maximumProduct(int[] nums) {
        int max = Integer.MIN_VALUE, second_max =  Integer.MIN_VALUE, third_max =  Integer.MIN_VALUE;
        int negative_min = 0, negative_second_min = 0;

        for(int num : nums) {
            if(num < negative_min){
                negative_second_min = negative_min;
                negative_min = num;
            } else if (num < negative_second_min) negative_second_min = num;

            if (num >= max) {
                third_max = second_max;
                second_max = max;
                max = num;
            } else if (num >= second_max) {
                third_max = second_max;
                second_max = num;
            } else if (num >= third_max) third_max = num;
        }
        return Math.max(second_max*third_max*max, negative_min*negative_second_min*max);
    }
}
