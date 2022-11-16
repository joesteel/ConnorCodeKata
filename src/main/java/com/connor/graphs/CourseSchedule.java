package com.connor.graphs;

import java.util.*;

public class CourseSchedule {

    public static Map<Integer, List<Integer>> createGraph(int target, List<List<Integer>> dependencies){
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int i = 0; i< target; i++){
            graph.put(i, new ArrayList<>());
        }
        dependencies.forEach(dependencyPair -> {
            int vertex = dependencyPair.get(0);
            int child = dependencyPair.get(1);
            if(!graph.containsKey(vertex)) graph.put(vertex, new ArrayList<>());
            List<Integer> children =  graph.get(vertex);
            if(!children.contains(child)) children.add(child);
        });
        return graph;
    }


    public static Map<Integer, Integer> countParents(Map<Integer, List<Integer>> graph){
        Map<Integer, Integer> parentCounts = new HashMap<>();
        graph.keySet().forEach(vertex->{
            parentCounts.put(vertex, 0);
        });
        graph.entrySet().forEach(vertexEdges->{
            for(int child: vertexEdges.getValue()){
                parentCounts.put(child, parentCounts.get(child)+1);
            }
        });
        return parentCounts;
    }

    public static boolean isValidCourseSchedule(int n, List<List<Integer>> prerequisites) {
        Map<Integer, List<Integer>>  graph = createGraph(n, prerequisites);
        Map<Integer, Integer> parentCounts = countParents(graph);
        ArrayDeque<Integer> q = new ArrayDeque<>();
        graph.keySet().forEach(vertex->{
            if(parentCounts.get(vertex) == 0) q.add(vertex);
        });
        boolean result = false;
        while(!q.isEmpty()){
            result = result || topologyDFS(n-1, q.pop(), graph, parentCounts);
            // should add a visited list too so we don't repeat paths but it should work without it
        }
        return result;
    }

    public static boolean topologyDFS(int target, int current, Map<Integer, List<Integer>> graph, Map<Integer, Integer> parentCounts){
        if(target ==  current) return true;
        boolean result = false;
        for(int child: graph.get(current)){
            parentCounts.put(child, parentCounts.get(child)-1);
            if(parentCounts.get(child) == 0){
                result = result || topologyDFS(target, child, graph, parentCounts);
            }
        }
        return result;
    }
}

