package com.connor.graphs;

import java.util.*;

public class TaskScheduling {
    public static <T> Map<T, List<T>> createMap(List<T> vertices, List<List<T>> graph){
        Map<T, List<T>> map = new HashMap<>();
        for(T vertex:vertices){
            map.put(vertex, new ArrayList<T>());
        }
        for(List<T> edgesForVertex:graph){
            T key = edgesForVertex.get(0);
            for(int i = 1; i < edgesForVertex.size(); i++){
                map.get(key).add(edgesForVertex.get(i));
            }
        }
        return map;
    }

    public static <T> Map<T, Integer> initializeCounts(Map<T, List<T>> graph){
        HashMap<T, Integer> counts = new HashMap<>();
        graph.keySet().forEach(key->{
            counts.put(key, 0);
        });
        graph.entrySet().forEach(edgesForNode->{
            for(T node:edgesForNode.getValue()){
                counts.put(node, counts.get(node)+1);
            }
        });
        return counts;
    }

    public static List<String> taskScheduling(List<String> tasks, List<List<String>> requirements) {
        ArrayDeque<String> q = new ArrayDeque<>();
        List<String> result = new ArrayList<>();
        Map<String, List<String>> graph = createMap(tasks, requirements);
        Map<String, Integer> counts = initializeCounts(graph);
        counts.keySet().forEach(key -> {
            if(counts.get(key) == 0) {
                q.add(key);
            }
        });

        while(!q.isEmpty()){
            String vertex = q.pop();
            result.add(vertex);
            graph.get(vertex).forEach(child -> {
                counts.put(child, counts.get(child)-1);
                if(counts.get(child) <= 0){
                    q.add(child);
                }
            });
        }
        return result.size() == graph.size() ? result : null;
    }
}
