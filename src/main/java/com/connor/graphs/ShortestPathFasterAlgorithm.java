package com.connor.graphs;

import java.util.*;

public class ShortestPathFasterAlgorithm {

    public static int shortestPath(List<List<Map.Entry<Integer, Integer>>> graph, int start, int target){
        if(target >= graph.size()) return -1;
        else return bfs(graph,start, target);
    }

    private static int bfs(List<List<Map.Entry<Integer, Integer>>> graph, int start, int target){
        ArrayDeque<Integer> q = new ArrayDeque<>();
        int[] distances = new int[graph.size()];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[start] = 0;
        q.add(start);

        while(!q.isEmpty()){
            int currentVertex = q.pop();
            for(Map.Entry<Integer, Integer> neighbour:getNeighbours(graph, currentVertex)){
                int neighbourVertex = neighbour.getKey();
                int neighbourWeight = neighbour.getValue();
                if(distances[currentVertex] + neighbourWeight < distances[neighbourVertex]){
                    distances[neighbourVertex] = distances[currentVertex] + neighbourWeight;
                    q.add(neighbourVertex);
                }
            }
        }

        return distances[target] < Integer.MAX_VALUE ? distances[target] : -1;
    }

    private static List<Map.Entry<Integer, Integer>> getNeighbours(List<List<Map.Entry<Integer, Integer>>> graph, int vertex){
        return graph.get(vertex);
    }


}
