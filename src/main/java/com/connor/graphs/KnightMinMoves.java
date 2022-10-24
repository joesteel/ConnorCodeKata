package com.connor.graphs;

import java.util.ArrayDeque;
import java.util.HashSet;

public class KnightMinMoves {

    public static int getKnightShortestPath(int x, int y) {
        return bfs(new Coordinate(0,0), x, y);
    }

    private static int bfs(Coordinate startingPos, int x, int y){
        int maxLevel = 100; // basically O(8^maxLevel) seems pretty massive
        HashSet<Coordinate> visited = new HashSet<>();
        ArrayDeque<Coordinate> queue = new ArrayDeque<>();
        queue.add(startingPos);
        visited.add(startingPos);
        int levelCount = 0;
        while(!queue.isEmpty()){
            if(levelCount >= maxLevel) break;
            int verticesInLevel = queue.size();
            for(int i = 0; i < verticesInLevel; i++){
                Coordinate currentCoordinate = queue.pop();
                if(currentCoordinate.r == x && currentCoordinate.c == y) return levelCount;
                for(Coordinate neighbour: currentCoordinate.getMoves()){
                    if(!visited.contains(neighbour)) {
                        queue.add(neighbour);
                        visited.add(neighbour);
                    }
                }
            }
            levelCount++;
        }
        return -1;
    }
}
