package com.connor.graphs;

import java.util.*;

public class ReconstructingSequence {

    public static <T> Map<T, List<T>> createGraph(List<T> original, List<List<T>> seq){
        Map<T, List<T>> map = new HashMap<>();
        for(T vertex:original){
            map.put(vertex, new ArrayList<T>());
        }
        for(List<T> edgesForVertex:seq){
            int i = 0, j = 1;
            while(j < edgesForVertex.size()){
                T key = edgesForVertex.get(i);
                List<T> edges = map.get(key);
                T edgeToAdd = edgesForVertex.get(j);
                if(!edges.contains(edgeToAdd)){
                    edges.add(edgeToAdd);
                }
                i++;
                j++;
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

    public static boolean sequenceReconstruction(List<Integer> original, List<List<Integer>> seqs) {
        ArrayDeque<Integer> q  = new ArrayDeque<>();
        Map<Integer, List<Integer>> graph = createGraph(original, seqs);
        Map<Integer, Integer> counts = initializeCounts(graph);
        List<Integer> res = new ArrayList<>();
        counts.keySet().forEach(key -> {
            if(counts.get(key) == 0){
                q.add(key);
            }
        });
        while(!q.isEmpty()){
            if(q.size() > 1) return false;
            int vertex = q.pop();
            res.add(vertex);
            for(int child:graph.get(vertex)){
                counts.put(child, counts.get(child)-1);
                if(counts.get(child) == 0) q.add(child);
            }
        }

        return res.equals(original);
    }
}
