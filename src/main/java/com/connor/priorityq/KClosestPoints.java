package com.connor.priorityq;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class KClosestPoints {
    public static List<List<Integer>> kClosestPoints(List<List<Integer>> points, int k) {
        List<List<Integer>> results = new ArrayList<>();

        PriorityQueue<List<Integer>> heap = new PriorityQueue<>(Comparator.comparingDouble(
                point->Math.sqrt(Math.pow(point.get(0),2) + Math.pow(point.get(1),2))
        ));
        for(List<Integer> point:points) heap.add(point);
        for(int i = 0; i < k; i++) results.add(heap.poll());
        return results;
    }

}
