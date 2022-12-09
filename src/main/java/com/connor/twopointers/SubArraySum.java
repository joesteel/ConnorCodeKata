package com.connor.twopointers;

import java.util.*;

public class SubArraySum {
    public static List<Integer> subarraySum(List<Integer> arr, int target) {
        int r_ptr = 0, runningSum = 0;
        Map<Integer, Integer> dictionary = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        while(r_ptr < arr.size()){
            runningSum += arr.get(r_ptr);
            dictionary.put(runningSum, r_ptr);
            if(runningSum == target) return new ArrayList<>(Arrays.asList(0, r_ptr+1));
            int compliment = runningSum - target;
            if(dictionary.get(compliment) != null) {
                result.add(dictionary.get(compliment)+1);
                result.add(r_ptr);
                break;
            }
            r_ptr++;
        }
        return result;
    }

    public static int subarraySumTotal(List<Integer> arr, int target) {
        int ptr = 0, runningSum = 0, result = 0;
        Map<Integer, Integer> dictionary = new HashMap<>();
        dictionary.put(0,1);
        while(ptr < arr.size()){
            runningSum += arr.get(ptr);
            dictionary.merge(runningSum,1, (oldVal, newVal)->oldVal+newVal);
            int compliment = runningSum - target;
            if(dictionary.get(compliment) != null) {
                result+=dictionary.get(compliment);
            }
            ptr++;
        }
        return result;
    }

}
