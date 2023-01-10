package com.connor.dynamicprogramming;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.*;

public class KnapsackWO {

    public static List<Integer> knapsackWeightOnly(List<Integer> weights) {
        List<Integer> result = new ArrayList<>();
        dfs(0, result, weights, new boolean[weights.size()], new HashSet<Integer>(), 0);
        return result;
    }


    public static void dfs(int current, List<Integer> result, List<Integer> weights, boolean[] usedItems, Set<Integer> memo, int sumFromParent){
        int sum = current+sumFromParent;
        if(memo.contains(sum)) return;
        result.add(sum);
        for(int i = 0; i < weights.size(); i++){
            if(!usedItems[i]){
                usedItems[i] = true;
                dfs(weights.get(i),result, weights, usedItems, memo, sum);
                usedItems[i] = false;
            }
        }
        memo.add(sum);
    }


}
