package com.connor.graphs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Coordinate {
    int r;
    int c;

    public Coordinate(){
        this(0,0);
    }

    public Coordinate(String coordinate){
        List<Integer> coords = Arrays.asList(coordinate.split(" "))
                .stream()
                .map(s->Integer.parseInt(s))
                .collect(Collectors.toList());
        this.r = coords.get(0);
        this.c = coords.get(1);
    }

    public Coordinate(int r, int c){
        this.r = r;
        this.c = c;
    }

    public boolean equals(Coordinate comparator){
        return (this.r == comparator.r && this.c == comparator.c);
    }

    public List<Coordinate> getNeighbours(List<List<Integer>> grid){
        int[] neighbourRows = new int[]{-1, 0, 1, 0};
        int[] neighbourCols = new int[]{0, -1, 0, 1};
        List<Coordinate> neighbours = new ArrayList<>();

        for(int i = 0; i < neighbourRows.length; i++){
            Coordinate neighbour = new Coordinate(r+neighbourRows[i], c+neighbourCols[i]);
            if(neighbour.isValid(grid)) neighbours.add(neighbour);
        }
        return neighbours;
    }

    public boolean isValid(List<List<Integer>> grid){
        int maxRow = grid.size()-1;
        int maxCol = grid.get(0).size()-1;
        boolean result = true;
        if(this.c < 0 || this.r > maxCol || this.r < 0 || this.r > maxRow) result = false;
        return result;
    }

    public String serialize(){
        return Integer.toString(r) + " " + Integer.toString(c);
    }


}
