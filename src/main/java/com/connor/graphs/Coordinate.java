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

    public List<Coordinate> getMoves(){
        int[] neighbourRows = new int[]{4, 4,-4, -4, 1, 1, -1, -1};
        int[] neighbourCols = new int[]{1,-1, 1, -1, 4, -4, 4, -4};
        List<Coordinate> newPositions = new ArrayList<>();
        for(int i = 0; i < neighbourRows.length; i++){
            newPositions.add(new Coordinate(r+neighbourRows[i], c+neighbourCols[i]));
        }
        return newPositions;
    }

    public boolean isValid(List<List<Integer>> grid){
        int maxRow = grid.size()-1;
        int maxCol = grid.get(0).size()-1;
        boolean result = true;
        if(this.c < 0 || this.c > maxCol || this.r < 0 || this.r > maxRow) result = false;
        return result;
    }

    public String serialize(){
        return Integer.toString(r) + " " + Integer.toString(c);
    }

    @Override
    public int hashCode() {
        String serialised = this.serialize();
        int result = serialised.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        else if (!(o instanceof Coordinate))
            return false;
        else{
            Coordinate other = (Coordinate)o;
            return this.serialize().equals(other.serialize());
        }
    }
}
