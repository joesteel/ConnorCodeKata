package com.connor.graphs;

import java.util.*;

public class AlienLang {

    public static String alienOrder(List<String> words) {
        Map<Character, List<Character>> graph = createGraph(words);
        Map<Character, Integer> parentCount = countParents(graph);
        PriorityQueue<Character> heap = new PriorityQueue<>();

        parentCount.entrySet().forEach(vertex->{
            if(vertex.getValue() == 0) heap.add(vertex.getKey());
        });

        List<Character> result = new ArrayList<>();
        while(!heap.isEmpty()){
            Character vertex = heap.poll();
            result.add(vertex);
            for(Character child:graph.get(vertex)){
                parentCount.put(child, parentCount.get(child)-1);
                if(parentCount.get(child) == 0) {
                    heap.add(child);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(char c: result){
            sb.append(c);
        }
        String strRes = sb.toString();

        return  strRes.length() == graph.size() ?  strRes : "";
    }

    public static Map<Character, Integer> countParents(Map<Character, List<Character>> graph){
        Map<Character, Integer> parentCounts = new HashMap<>(graph.size());
        graph.keySet().forEach(c->{
            parentCounts.put(c,0);
        });
        graph.entrySet().forEach(entry-> {
            for(Character edge: entry.getValue()){
                parentCounts.merge(edge, 1, (a,b)->a+b);
            }
        });
        return parentCounts;
    }

    public static Map<Character, List<Character>> createGraph(List<String> words){
        Map<Character, List<Character>> graph = new HashMap<>();
        int ptr1 = 0, ptr2 = 1;
        while(ptr2 < words.size()){
            createGraphEntries(words.get(ptr1), words.get(ptr2), graph);
            ptr1++;
            ptr2++;
        }
        return graph;
    }

    private static void createGraphEntries(String w1, String w2, Map<Character, List<Character>> graph){
        for(char c:w1.toCharArray()) {
            graph.putIfAbsent(c, new ArrayList<>());
        }
        for(char c:w2.toCharArray()) {
            graph.putIfAbsent(c, new ArrayList<>());
        }
        int i = 0;
        while(i < w1.length() && i < w2.length()){
            if(w1.charAt(i) != w2.charAt(i)) {
                List<Character> edges = graph.get(w1.charAt(i));
                edges.add(w2.charAt(i));
                break;
            } else {
                i++;
            }
        }
    }


}
