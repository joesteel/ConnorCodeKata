package com.connor.graphs;

import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class FloodFill {

    public static List<List<Integer>> floodFill(int r, int c, int replacement, List<List<Integer>> image) {
        bfs(new Coordinate(r,c), replacement, image, image.size(), image.get(0).size());
        return image;
    }

    public static void bfs(Coordinate root, int replacement, List<List<Integer>> image, int numRows, int numCols){
        ArrayDeque<Coordinate> queue = new ArrayDeque<>();
        queue.add(root);
        boolean[][] visited = new boolean[numRows][numCols];
        visited[root.y][root.x] = true;
        int colorToReplace = image.get(root.y).get(root.x);

        while(!queue.isEmpty()){
            Coordinate currentCord = queue.pop();
            image.get(currentCord.y).set(currentCord.x, replacement);
            for(Coordinate neighbour:getNeighbours(currentCord, numRows, numCols)){
                if(visited[neighbour.y][neighbour.x]) continue;
                if(image.get(neighbour.y).get(neighbour.x) == colorToReplace){
                    queue.add(neighbour);
                    visited[neighbour.y][neighbour.x] = true;
                }
            }
        }
    }
    public static List<Coordinate> getNeighbours(Coordinate point, int numRows, int numCols){
        // horizontal and vertical shift
        List<Coordinate> result = new ArrayList<>();
        int[] x_shifts = new int[]{0, -1, 0, 1};
        int[] y_shifts = new int[]{-1, 0, 1, 0};

        for(int i = 0; i < x_shifts.length; i++){
            int x = point.x + x_shifts[i];
            int y = point.y + y_shifts[i];
            Coordinate cord = new Coordinate(x,y);
            if(cord.isValid(numCols, numRows)) {
                result.add(cord);
            }
        }
        return result;
    }

    public static class Coordinate {
        public int x;
        public int y;

        public Coordinate(){
            new Coordinate(0,0);
        }
        public Coordinate(int x, int y){
            this.x = x;
            this.y = y;
        }
        boolean isValid(int maxX, int maxY){
            if(x < 0 || x >= maxX) return false;
            if(y < 0 || y >= maxY) return false;
            return true;
        }

    }
}
