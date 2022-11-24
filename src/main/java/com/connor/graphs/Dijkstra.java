package com.connor.graphs;

import java.util.*;

public class Dijkstra {

    public static int shortestPath(List<List<Map.Entry<Integer, Integer>>> graph, int root, int target){
        return bfs(graph, root, target);
    }

    public static List<Map.Entry<Integer, Integer>> getNeighbours(int node, List<List<Map.Entry<Integer, Integer>>> graph){
        return graph.get(node);
    }

    public static class Tuple {
        public int node;
        public int distanceFromRoot;
        public Tuple(int node, int distanceFromRoot){
            this.node = node;
            this.distanceFromRoot = distanceFromRoot;
        }
    }

    private static int bfs(List<List<Map.Entry<Integer, Integer>>> graph, int root, int target) {
        PriorityQueue<Tuple> q = new PriorityQueue<>(Comparator.comparingInt(t->t.distanceFromRoot));
        int[] distances = new int[graph.size()];
        Arrays.fill(distances, Integer.MAX_VALUE);
        int distanceFromRoot = 0;
        distances[root] = distanceFromRoot;
        q.add(new Tuple(0, distanceFromRoot));

        while(!q.isEmpty()){
            Tuple currentVertex = q.poll();
            distanceFromRoot = currentVertex.distanceFromRoot;
            for (Map.Entry<Integer, Integer> neighbour: getNeighbours(currentVertex.node, graph)) {
                int distanceToNeighbour = distanceFromRoot+neighbour.getValue();
                if(distances[neighbour.getKey()] > distanceToNeighbour){
                    q.add(new Tuple(neighbour.getKey(), distanceToNeighbour));
                    distances[neighbour.getKey()] = distanceToNeighbour;
                }
            }
        }
        return distances[target];
    }
}

