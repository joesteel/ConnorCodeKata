package com.connor.priorityq;

import java.util.*;

public class UglyNumber {

    public static int nthUglyNumber(int n) {
        int[] allowedPrimeFactors = new int[]{2,3,5};
        List<Integer> results = new ArrayList<>(n);
        Set<Integer> usedNums = new HashSet<>();
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        heap.add(1);
        for(int i = 0; i < n; i++){
            int num = heap.poll();
            results.add(num);
            for(int uglyFactor:allowedPrimeFactors){
                int uglyNum = num*uglyFactor;
                if(!usedNums.contains(uglyNum)){
                    heap.add(uglyNum);
                    usedNums.add(uglyNum);
                }
            }
        }
        return results.get(n-1);
    }

}
