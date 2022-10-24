package com.connor.graphs;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.List;

public class NumberOfIslands {

    public static int countNumberOfIslands(List<List<Integer>> grid) {
        HashSet<String> unvisitedSet = createUnvisitedSet(grid);
        int result = 0;
        while(unvisitedSet.iterator().hasNext()){
            Coordinate coordinate = new Coordinate(unvisitedSet.iterator().next());
            result += bfs(unvisitedSet, grid, coordinate);
        }
        return result;
    }


    public static int bfs(HashSet<String> unvisited, List<List<Integer>> grid, Coordinate startingPoint){
        int containsIsland = grid.get(startingPoint.r).get(startingPoint.c);
        ArrayDeque<Coordinate> queue = new ArrayDeque<>();
        queue.add(startingPoint);

        while(!queue.isEmpty()){
            Coordinate current = queue.pop();
            for(Coordinate neighbour: current.getNeighbours(grid)){
                if(unvisited.contains(neighbour.serialize()) && grid.get(neighbour.r).get(neighbour.c) == containsIsland){
                    queue.add(neighbour);
                    unvisited.remove(neighbour.serialize());
                }
            }
            unvisited.remove(current.serialize());
        }

        return containsIsland;
    }

    public static HashSet<String> createUnvisitedSet(List<List<Integer>> grid){
        HashSet<String> set = new HashSet<>();
        for(int i = 0; i < grid.size(); i++){
            for(int j = 0; j < grid.get(i).size(); j++){
                set.add(new Coordinate(i,j).serialize());
            }
        }
        return set;
    }

}
