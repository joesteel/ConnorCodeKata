package com.connor.graphs;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.List;

public class ShortestPath {

    public static int shortestPath(List<List<Integer>> graph, int a, int b) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.add(a);
        HashSet<Integer> visited = new HashSet<>();
        visited.add(a);
        int depth = 0;
        while(!queue.isEmpty()){
            int n = queue.size();
            for(int i = 0; i < n; i++){
                int vertex = queue.pop();
                if(vertex == b) return depth;
                for(int neighbour:getNeighbours(vertex, graph)) {
                    if (visited.contains(neighbour)) {
                        continue;
                    }
                    queue.add(neighbour);
                    visited.add(neighbour);
                }
            }
            depth++;
        }
        return -1;
    }

    private static List<Integer> getNeighbours(int vertex, List<List<Integer>> graph){
        return graph.get(vertex);
    }



}
