package com.connor.dynamicprogramming;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.*;

public class KnapsackWO {


    public static List<Integer> knapsackWeightOnly(List<Integer> weights, String type) {
        switch (type) {
            case "bottom up" : return kwoBottomUp(weights);
            default:  return kwoTopDown(weights);
        }
    }

    public static List<Integer> knapsackWeightOnly(List<Integer> weights) {
        return kwoTopDown(weights);
    }


    public static List<Integer> kwoTopDown(List<Integer> weights){
        if(weights.size() == 0) return new ArrayList<>(Arrays.asList(0));
        Set<Integer> sums = new HashSet<>();
        int maxSum = weights
                .stream()
                .mapToInt(x->x)
                .sum();
        dfs(0,  weights, sums, new boolean[weights.size()][maxSum+1], 0);
        return new ArrayList<>(sums);
    }

    public static void dfs(int currentLevel, List<Integer> weights, Set<Integer> sums, boolean[][] memo, int runningTotal){
        if(currentLevel == weights.size()) {
            sums.add(runningTotal);
            return;
        }
        if(!memo[currentLevel][runningTotal]){
            dfs(currentLevel+1, weights, sums, memo, runningTotal);
            dfs(currentLevel+1, weights, sums, memo, runningTotal+weights.get(currentLevel));
        }
        memo[currentLevel][runningTotal] = true;
    }

    public static List<Integer> kwoBottomUp(List<Integer> weights) {
        int maxSum = weights.stream().mapToInt(x->x).sum();
        boolean[][] stateSpace = new boolean[weights.size()+1][maxSum+1];
        List<Integer> result = new ArrayList<>();
        stateSpace[0][0] = true;
        for(int i = 1; i <= weights.size(); i++){
            for(int j = 0; j < stateSpace[0].length; j++){
                if(stateSpace[i-1][j]) {
                    stateSpace[i][j] = true;
                    stateSpace[i][j+weights.get(i-1)] = true;
                }
            }
        }
        for(int j = 0; j < stateSpace[0].length; j++){
            if(stateSpace[stateSpace.length-1][j]) result.add(j);
        }
        return result;
    }

}
