package com.connor.twopointers;

import java.util.List;

public class GetMaxScore {
    public static final int LIMIT = 1000000007;
    public static int maximumScore(List<Integer> arr1, List<Integer> arr2) {
        long result = 0;
        int windowOneSum = 0, windowTwoSum = 0;
        int ptr1 = 0, ptr2 = 0;
        while(ptr1 < arr1.size() && ptr2 < arr2.size()){
            if(arr1.get(ptr1) < arr2.get(ptr2) && ptr1 < arr1.size()){
                windowOneSum += arr1.get(ptr1);
                ptr1++;
            } else if (arr1.get(ptr1) > arr2.get(ptr2) && ptr2 < arr2.size()){
                windowTwoSum += arr2.get(ptr2);
                ptr2++;
            } else if (arr1.get(ptr1).equals(arr2.get(ptr2))){ // window closed
                windowOneSum += arr1.get(ptr1);
                windowTwoSum += arr2.get(ptr2);
                result += Math.max(windowOneSum, windowTwoSum) % LIMIT;
                windowOneSum = 0;
                windowTwoSum = 0;
                ptr1++;
                ptr2++;
            }
        }
        for(; ptr1 < arr1.size();ptr1++) windowOneSum += arr1.get(ptr1);
        for(; ptr2 < arr2.size();ptr2++) windowTwoSum += arr2.get(ptr2);
        result += Math.max(windowOneSum, windowTwoSum) % LIMIT;
        return (int)result;
    }
}
