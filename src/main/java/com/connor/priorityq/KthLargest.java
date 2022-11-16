package com.connor.priorityq;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class KthLargest {

    public static int findKthLargest(List<Integer> nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
        for(int num:nums){
            heap.add(num);
        }
        int result = 0;
        for(int i = 0; i < k; i++){
            result = heap.poll();
        }
        return result;
    }

}
