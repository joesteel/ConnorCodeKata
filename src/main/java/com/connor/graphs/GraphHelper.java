package com.connor.graphs;

import java.util.*;

public class GraphHelper {

    public static List<List<Map.Entry<Integer, Integer>>> deserializeGraph(String serializedGraph){
        List<List<Map.Entry<Integer, Integer>>> graph = new ArrayList<>();
        List<String> vertices = Arrays.asList(serializedGraph.split("-vertexStart-"));
        Iterator<String> itr = vertices.iterator();

        int graphSize = Integer.parseInt(itr.next());
        for(int i = 0; i <graphSize; i++){
            graph.add(new ArrayList<>());
        }

        int currentVertex = 0;
        while(itr.hasNext()){
            List<Map.Entry<Integer, Integer>> vertex = graph.get(currentVertex);
            String[] neighbours = itr.next().split(" ");
            for(int i = 0; i < neighbours.length;){
                Map.Entry<Integer, Integer> child = new AbstractMap.SimpleEntry(Integer.parseInt(neighbours[i]), Integer.parseInt(neighbours[i+1]));
                i += 2;
                vertex.add(child);
            }
            currentVertex++;
        }

        return graph;
    }
}
