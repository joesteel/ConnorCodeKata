package com.connor.priorityq;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class KthSmallestMatrix {
    private static class Element{
        int head;
        List<Integer> list;
        public Element(List<Integer> list){
            this.list = list;
            head = 0;
        }
        public int getVal() {return list.get(head);}
    }

    public static int kthSmallest(List<List<Integer>> matrix, int k) {
        PriorityQueue<Element> heap = new PriorityQueue<>(Comparator.comparingInt(e->e.getVal()));
        for(int i = 0; i < matrix.size(); i++){
            if(matrix.get(i).size() > 0) heap.add(new Element(matrix.get(i)));
        }
        for(int i = 1; i < k; i ++) {
            Element e = heap.poll();
            e.head++;
            if(e.head < e.list.size()) heap.add(e);
        }
        return heap.poll().getVal();
    }

}