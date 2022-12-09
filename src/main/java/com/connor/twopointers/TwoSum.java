package com.connor.twopointers;

import java.util.Arrays;
import java.util.List;

public class TwoSum {

    public static List<Integer> twoSumSorted(List<Integer> arr, int target) {
        int left = 0, right = arr.size()-1;
        int sum = -1;
        while(left < right){
            sum = arr.get(left) + arr.get(right);
            if(sum > target) right--;
            else if(sum < target) left++;
            else break;
        }
        return sum == target ? Arrays.asList(left, right) : null;
    }
}
