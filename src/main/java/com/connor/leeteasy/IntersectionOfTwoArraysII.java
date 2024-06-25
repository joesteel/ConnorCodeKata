package com.connor.leeteasy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IntersectionOfTwoArraysII {
    // Sorting the arrays and using pointers is faster ! 
    public static int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> intersection = new ArrayList<>();
        Map<Integer, Integer> frequencyMap1 = new HashMap<>();

        for(int num: nums1){
            frequencyMap1.computeIfPresent(num, (x,y)->y+1);
            frequencyMap1.putIfAbsent(num, 1);
        }
        for(int num2: nums2) {
            if(frequencyMap1.containsKey(num2) && frequencyMap1.get(num2) > 0){
                intersection.add(num2);
                frequencyMap1.put(num2, frequencyMap1.get(num2)-1);
            }
        }
        return intersection.stream().mapToInt(x->x).toArray();
    }
}
