package com.connor.graphs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class OpenLock {

    public static List<String> getNeighbours(String combo){
        List<String> neighbours = new ArrayList<>();
        for(int i = combo.length()-1; i>=0; i--){
            StringBuilder neighbour = new StringBuilder(combo);
            int val = Integer.parseInt(neighbour.substring(i, i+1));
            if(val < 9) {
                neighbour.replace(i, i+1, Integer.toString(val+1));
            }
            else neighbour.replace(i, i+1,"0");
            neighbours.add(neighbour.toString());
        }
        for(int i = combo.length()-1; i>=0; i--){
            StringBuilder neighbour = new StringBuilder(combo);
            int val = Integer.parseInt(neighbour.substring(i, i+1));
            if(val == 0) {
                neighbour.replace(i, i+1, Integer.toString(9));
            }
            else neighbour.replace(i, i+1,Integer.toString(val-1));
            neighbours.add(neighbour.toString());
        }
        return neighbours;
    }
    public static int numSteps(String targetCombo, List<String> trappedCombos) {
        ArrayDeque<String> deque = new ArrayDeque<>();
        deque.add("0000");
        HashSet<String> visited = new HashSet<>();
        visited.add("0000");
        int level = 0;

        while(!deque.isEmpty()){
            int verticesInLevel = deque.size();
            for(int i=0; i<verticesInLevel;i++){
                String currentCombo = deque.pop();
                if(trappedCombos.contains(currentCombo)) return -1;
                else if (currentCombo.equals(targetCombo)) return level;
                for(String nextCombo:getNeighbours(currentCombo)){
                    if(!visited.contains(nextCombo) && !trappedCombos.contains(nextCombo)){
                        deque.add(nextCombo);
                        visited.add(nextCombo);
                    }
                }
            }
            level++;
        }
        return -1;
    }
}
