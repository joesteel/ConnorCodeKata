package com.connor.leeteasy;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> index_lookup_map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            int compliment = target - nums[i];
            if(index_lookup_map.get(compliment) != null) {
               result[0] = index_lookup_map.get(compliment);
               result[1] = i;
            }
            index_lookup_map.put(nums[i], i);
      }
      return result;
    }
}
