package com.connor.priorityq;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class ReorganizeString {

    private static class Tuple{
        public char c;
        public int count;

        public Tuple(char c, int count){
            this.c = c;
            this.count = count;
        }
    }

    public static String reorganizeString(String s) {
        int size = s.length();
        int evens = size/2 + size%2;
        PriorityQueue<Tuple> heap = new PriorityQueue<>(Comparator.comparingInt(t->-(t.count)));
        Map<Character, Integer> lengths = new HashMap<>();
        for (char c: s.toCharArray()) {
            lengths.merge(c, 1, Integer::sum);
            if(lengths.get(c) > evens) return "";
        }
        lengths.entrySet().forEach(entry->{
            heap.add(new Tuple(entry.getKey(), entry.getValue()));
        });
        char[] result = new char[size];
        int ptr = 0;
        while(!heap.isEmpty()){
            Tuple t = heap.poll();
            for(int i = 0; i < t.count; i++){
                result[ptr] = t.c;
                ptr+=2;
                if(ptr >= result.length) ptr = 1;
            }
        }
        return new String(result);
    }

}
