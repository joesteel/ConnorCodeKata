package com.connor.priorityq;

import java.util.*;

public class MergeKSortedLists {

    public static List<Integer> mergeKSortedLists(List<List<Integer>> lists) {
        if(lists.size() == 1) return lists.get(0);

        int combinedSize = 0;
        for(int i = 0; i< lists.size();i++) combinedSize+=lists.get(i).size();

        List<Integer> result = new ArrayList<>(combinedSize);
        if(combinedSize > 0) {
            PriorityQueue<Integer> heap = new PriorityQueue<>();
            int[] ptrs = new int[lists.size()];
            Arrays.fill(ptrs, 0);

            for (int i = 0; i < lists.size(); i++) heap.add(lists.get(i).get(ptrs[i]));

            while(result.size() < combinedSize) {
                int smallest = heap.poll();
                result.add(smallest);
                for (int i = 0; i < lists.size(); i++) {
                    if (smallest == lists.get(i).get(ptrs[i])) {
                        if (ptrs[i] < lists.get(i).size()-1) {
                            ptrs[i]++;
                            heap.add(lists.get(i).get(ptrs[i]));
                            break;
                        }
                    }
                }
            }
        }
        return result;
    }

    public static List<Integer> mergeSortedListsUsingElement(List<List<Integer>> lists){
        int combinedSize = 0;
        PriorityQueue<Element> heap = new PriorityQueue<>(Comparator.comparingInt(h->h.getVal()));
        for(int i = 0; i< lists.size(); i++){
            combinedSize+=lists.get(i).size();
            if(lists.get(i).size() > 0) {
                Element e = new Element(lists.get(i));
                heap.add(e);
            }
        }
        List<Integer> result = new ArrayList<>(combinedSize);
        while(!heap.isEmpty()){
            Element smallest = heap.poll();
            result.add(smallest.getVal());
            smallest.head++;
            if(smallest.head < smallest.list.size()) heap.add(smallest);
        }
        return result.size() == combinedSize ? result : null;
    }


    private static class Element{
        public List<Integer> list;
        public int head;

        public Element(List<Integer> list){
            this.list = list;
            head = 0;
        }

        public int getVal() {
            return list.get(head);
        }
    }
}
