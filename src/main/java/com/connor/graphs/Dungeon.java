package com.connor.graphs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Dungeon {

    private static final int INF = Integer.MAX_VALUE;

    public static List<List<Integer>> mapGateDistances(List<List<Integer>> dungeonMap){
        return mapGateDistances(dungeonMap, 0);
    }

    public static List<List<Integer>> mapGateDistances(List<List<Integer>> dungeonMap, int type) {
        switch (type){
            case 0:
                return mapGateDistancesWithDFS(dungeonMap);
            default:
                return mapGateDistancesWithBFS(dungeonMap);
        }
    }

    public static List<List<Integer>> mapGateDistancesWithDFS(List<List<Integer>> dungeonMap){
        List<List<Integer>> result = new ArrayList<>(dungeonMap);
        int rows = dungeonMap.size(), cols = dungeonMap.get(0).size();

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(result.get(i).get(j) == INF) dfs(new Coordinate(i,j), new boolean[rows][cols], result);
            }
        }
        return result;
    }

    public static int dfs(Coordinate coordinate, boolean[][] visited, List<List<Integer>> mapWithDistances){
        if(mapWithDistances.get(coordinate.r).get(coordinate.c) < INF) return mapWithDistances.get(coordinate.r).get(coordinate.c);

        visited[coordinate.r][coordinate.c] = true;
        int result = INF;
        for(Coordinate neighbour: coordinate.getNeighbours(mapWithDistances)){
            if(visited[neighbour.r][neighbour.c] != true && mapWithDistances.get(neighbour.r).get(neighbour.c) != -1){
                result = Math.min( result, dfs(neighbour, visited, mapWithDistances));
            }
        }
        if(result < INF) result++;
        mapWithDistances.get(coordinate.r).set(coordinate.c, result);
        return result;
    }

    public static List<List<Integer>> mapGateDistancesWithBFS(List<List<Integer>> dungeonMap){
        List<List<Integer>> result = new ArrayList<>(dungeonMap);
        int rows = dungeonMap.size(), cols = dungeonMap.get(0).size();

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(result.get(i).get(j) == 0) bfs(new Coordinate(i,j), result);
            }
        }
        return result;
    }

    public static void bfs(Coordinate startingCoordinate, List<List<Integer>> mapWithDistances){
        ArrayDeque<Coordinate> queue = new ArrayDeque<>();
        queue.add(startingCoordinate);
        HashSet<Coordinate> visited = new HashSet<>();
        visited.add(startingCoordinate);
        int level = 0;

        while(!queue.isEmpty()){
            int verticesInQueue = queue.size();
            for(int i = 0; i < verticesInQueue; i++){
                Coordinate currentCoord = queue.pop();
                int distance =  Math.min(mapWithDistances.get(currentCoord.r).get(currentCoord.c),level);
                mapWithDistances.get(currentCoord.r).set(currentCoord.c, distance);
                for(Coordinate neighbour: currentCoord.getNeighbours(mapWithDistances)){
                    if(!visited.contains(neighbour)){
                        queue.add(neighbour);
                        visited.add(neighbour);
                    }
                }
            }
            level++;
        }
    }
}
