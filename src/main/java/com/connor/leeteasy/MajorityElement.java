package com.connor.leeteasy;

import java.util.HashMap;

public class MajorityElement {

    public static int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = (nums.length+1)/2;
        for (int num : nums) {
            map.computeIfPresent(num, (key, sum) -> sum + 1);
            map.putIfAbsent(num, 1);
            if (map.get(num) >= max) {
                return num;
            }
        }
        return -1;
    }
}
