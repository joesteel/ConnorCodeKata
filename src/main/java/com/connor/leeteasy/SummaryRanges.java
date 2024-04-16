package com.connor.leeteasy;

import java.util.LinkedList;
import java.util.List;

public class SummaryRanges {
    public static List<String> summaryRanges(int[] nums) {
        int ptr1 = 0, ptr2 = 0;
        List<String> result = new LinkedList<>();
        while(ptr1 < nums.length){
            while(ptr2 < nums.length){
                if(nums[ptr2] - nums[ptr1] != ptr2 - ptr1) break;
                ptr2++;
            }
            if(ptr2 - ptr1 == 1) result.add(String.valueOf(nums[ptr1]));
            else result.add(String.valueOf(nums[ptr1]) + "->" + String.valueOf(nums[ptr2-1]));
            ptr1 = ptr2;
        }
        return result;
    }
}
