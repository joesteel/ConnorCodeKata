package com.connor.graphs;

import java.util.*;

public class SlidingPuzzle {

    public static int numSteps(List<List<Integer>> initPos) {
        int targetPos = 123450;
        HashSet<Integer> visited = new HashSet<>();
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        int serializedBoard = serializeBoard(initPos);
        deque.add(serializedBoard);
        visited.add(serializedBoard);
        int level = 0;
        while(!deque.isEmpty()){
            if(level > 20) return -1;
            int verticesInLevel = deque.size();
            for(int i = 0; i < verticesInLevel; i++){
                int serializedCurrentLayout = deque.poll();
                if(serializedCurrentLayout == targetPos) return level;
                List<List<Integer>> currentBoard = deserializeBoard(serializedCurrentLayout);
                for(List<List<Integer>> neighbour:getNeighbours(currentBoard)){
                    int serializedNeighbour = serializeBoard(neighbour);
                    if(!visited.contains(serializedNeighbour)){
                        deque.add(serializedNeighbour);
                        visited.add(serializedNeighbour);
                    }
                }
            }
            level++;
        }
        return level;
    }

    public static List<List<List<Integer>>> getNeighbours(final List<List<Integer>> currentLayout){
     // find the co-ordinate where the 0 is
        // then do all the swaps, add the result to the big list and return it
        List<List<List<Integer>>> neighbours = new ArrayList<>();
        for(int r = 0; r < currentLayout.size(); r++){
            for(int c = 0; c < currentLayout.get(0).size(); c++){
                if(currentLayout.get(r).get(c) == 0) {
                    for(int i = 0; i < 4; i++){
                        List<List<Integer>> neighbour = doSwaps(r,c, currentLayout, i);
                        if(neighbour!=null) neighbours.add(neighbour);
                    }
                }
            }
        }
        return neighbours;
    }

    public static List<List<Integer>> doSwaps(int r, int c, List<List<Integer>> currentLayout, int swapType){
        switch (swapType) {
            case 0:
                return swapUp(r,c, currentLayout);
            case 1:
                return swapDown(r,c, currentLayout);
            case 2:
                return swapLeft(r,c, currentLayout);
            case 3:
                return swapRight(r,c, currentLayout);
            default:
                return null;
        }
    }

    public static List<List<Integer>> swapUp(int r, int c, final List<List<Integer>> currentLayout){
        if(r == 0) return null;
        else return swapVertical(r,c,currentLayout,true);

    }

    public static List<List<Integer>> swapDown(int r, int c, final List<List<Integer>> currentLayout){
        if(r == currentLayout.size()-1) return null;
        else return swapVertical(r,c,currentLayout,false);
    }

    public static List<List<Integer>> swapVertical(int r, int c, final List<List<Integer>> currentLayout, boolean up){
        List<Integer> top = new ArrayList<>(currentLayout.get(0));
        List<Integer> bottom = new ArrayList<>(currentLayout.get(1));
        if(up) {
            bottom.set(c, top.get(c));
            top.set(c, 0);
        } else {
            top.set(c, bottom.get(c));
            bottom.set(c,0);
        }
        List<List<Integer>> result = new ArrayList<>();
        result.add(top);
        result.add(bottom);
        return result;
    }

    public static List<List<Integer>> swapLeft(int r, int c, final List<List<Integer>> currentLayout) {
        if (c <= 0) return null;
        else return swapHorizontal(r,c,currentLayout, true);
    }

    public static List<List<Integer>> swapRight(int r, int c, final List<List<Integer>> currentLayout){
        if (c >= currentLayout.get(0).size()-1) return null;
        else return swapHorizontal(r,c,currentLayout, false);
    }

    public static List<List<Integer>> swapHorizontal(int r, int c, final List<List<Integer>> currentLayout, boolean left)
    {
        List<Integer> top = new ArrayList<>(currentLayout.get(0));
        List<Integer> bottom = new ArrayList<>(currentLayout.get(1));
        List<List<Integer>> result = new ArrayList<>();
        result.add(top);
        result.add(bottom);
        if(left) Collections.swap(result.get(r), c, c - 1);
        else Collections.swap(result.get(r), c, c + 1);
        return result;
    }

    public static int serializeBoard(final List<List<Integer>> currentLayout){
       int result = 0;
       int maxPower = currentLayout.size() * currentLayout.get(0).size() - 1;
        for(int r = 0; r < currentLayout.size(); r++){
            for(int c = 0; c < currentLayout.get(0).size(); c++){
                result += currentLayout.get(r).get(c) * Math.pow(10, maxPower--);
            }
        }
        return result;
    }

    public static List<List<Integer>> deserializeBoard(int serializedBoard){
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> top = new ArrayList<>();
        List<Integer> bottom = new ArrayList<>();
        result.add(top);
        result.add(bottom);
        for(int i = 0; i < 6; i++){
            int val = serializedBoard/(int)Math.pow(10, i) % 10;
            if(i < 3) bottom.add(0,val);
            else top.add(0,val);
        }
        return result;
    }
}
