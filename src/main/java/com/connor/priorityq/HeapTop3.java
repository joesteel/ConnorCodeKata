package com.connor.priorityq;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class HeapTop3 {

    public static List<Integer> heapTop3(List<Integer> arr) {
        // WRITE YOUR BRILLIANT CODE HERE
        List<Integer> top3 = new ArrayList<>();
        PriorityQueue<Integer> heap = new PriorityQueue<>(arr);
        top3.add(heap.poll());
        top3.add(heap.poll());
        top3.add(heap.poll());
        return top3;
    }

}
