package com.connor.leeteasy;

import java.util.PriorityQueue;

class KthLargest {
    PriorityQueue<Integer> minHeap;
    int k;

    public KthLargest(int k, int[] nums) {
        minHeap = new PriorityQueue<>();
        this.k = k;
        for(int num : nums) insertInHeap(num);
    }

    public int add(int val) {
        insertInHeap(val);
        return !minHeap.isEmpty() ? minHeap.peek() : Integer.MAX_VALUE;
    }

    private void insertInHeap(int val) {
        if(minHeap.size() < k || (!minHeap.isEmpty() && minHeap.peek() <= val)) minHeap.add(val);
        if(minHeap.size() > k) minHeap.remove();
    }
}