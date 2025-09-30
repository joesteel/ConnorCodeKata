package com.connor.leeteasy;

import java.util.ArrayList;
import java.util.HashMap;

public class DegreeOfAnArray {

    public static int findShortestSubArray(int[] nums) {
        HashMap<Integer, NumDigest> frequency_map = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            frequency_map.putIfAbsent(nums[i], new NumDigest(0, i, i));
            NumDigest nd = frequency_map.get(nums[i]);
            nd.frequency += 1;
            nd.end_index = i;
        }

        int max = Integer.MIN_VALUE, shortest_sub_arr_len = Integer.MAX_VALUE;
        ArrayList<NumDigest> candidates = new ArrayList<>();
        for(int key : frequency_map.keySet()) {
            NumDigest nd = frequency_map.get(key);
            if(nd.frequency >= max) {
                max = nd.frequency;
                candidates.add(nd);
            }
        }

        for(NumDigest candidate : candidates) {
            if(candidate.frequency == max) {
                shortest_sub_arr_len = Math.min(shortest_sub_arr_len, candidate.end_index - candidate.start_index + 1);
            }
        }

        return shortest_sub_arr_len;
    }

    private static class NumDigest {
        int frequency;
        int start_index;
        int end_index;

        NumDigest(int frequency, int start_index, int end_index) {
            this.frequency = frequency;
            this.start_index = start_index;
            this.end_index = end_index;
        }
    }
}
