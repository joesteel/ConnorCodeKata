package com.connor.graphs;

import java.util.*;

public class TaskSchedulingWithTimes {

    public static Map<String, List<String>> createGraphMap(List<String> tasks, List<List<String>> dependencies){
        Map<String, List<String>> graph = new HashMap<>();
        for(String task:tasks){
            graph.put(task, new ArrayList<>());
        }
        for(List<String> dependencyList:dependencies){
            String vertex = dependencyList.get(0);
            List<String> edges = graph.get(vertex);
            for(int i = 1; i < dependencyList.size();i++){
                edges.add(dependencyList.get(i));
            }
        }
        return graph;
    }

    public static Map<String, Integer> countIncomingEdges(Map<String, List<String>> graph){
        Map<String, Integer> counts = new HashMap<>();
        graph.keySet().forEach(vertex->{
            counts.put(vertex, 0);
        });
        graph.entrySet().forEach(edges->{
            for(String edge: edges.getValue()){
                counts.put(edge, counts.get(edge)+1);
            }
        });
        return counts;
    }

    public static Map<String, List<String>> createParentMap(List<String> tasks){
        Map<String, List<String>> parentMap = new HashMap<>();
        for(String task:tasks){
            parentMap.put(task, new ArrayList<>());
        }
        return parentMap;
    }

    public static int taskScheduling2(List<String> tasks, List<Integer> times, List<List<String>> requirements) {
        ArrayDeque<String> q = new ArrayDeque<>();
        Map<String, List<String>> graph = createGraphMap(tasks, requirements);
        Map<String, Integer> counts = countIncomingEdges(graph);
        Map<String, Integer> timeToVertices = new HashMap<>();
        int minTimeToExecuteDAG = 0;
        counts.keySet().forEach(vertex -> {
            if(counts.get(vertex) == 0) {
                q.add(vertex);
            }
            timeToVertices.put(vertex,0);
        });

        while(!q.isEmpty()){
            String vertex = q.pop();
            timeToVertices.put(vertex, timeToVertices.get(vertex)+times.get(tasks.indexOf(vertex)));
            for(String childVertex: graph.get(vertex)){
                counts.put(childVertex, counts.get(childVertex)-1);
                if(counts.get(childVertex) == 0) q.add(childVertex);
                int childTime = Math.max(timeToVertices.get(vertex), timeToVertices.get(childVertex));
                timeToVertices.put(childVertex, childTime);
            }
            minTimeToExecuteDAG = Math.max(timeToVertices.get(vertex), minTimeToExecuteDAG);
        }
        return minTimeToExecuteDAG;
    }
}
