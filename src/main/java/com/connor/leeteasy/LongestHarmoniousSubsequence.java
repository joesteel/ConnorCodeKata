package com.connor.leeteasy;

import java.util.HashMap;
import java.util.Map;

public class LongestHarmoniousSubsequence {

    public static int findLHS(int[] nums) {
        Map<Integer, Integer> fm = new HashMap<>();
        int lhs = 0;
        for (int num: nums) {
            fm.computeIfPresent(num, (k,v)-> v+1);
            fm.putIfAbsent(num, 1);
        }

        for(int num : nums){
            int higher = fm.getOrDefault(num+1, 0);
            if(higher > 0) lhs = Math.max(lhs, higher+fm.get(num));
            int lower = fm.getOrDefault(num-1, 0);
            if(lower > 0) lhs = Math.max(lhs, lower+fm.get(num));
        }
        return lhs;
    }
}
