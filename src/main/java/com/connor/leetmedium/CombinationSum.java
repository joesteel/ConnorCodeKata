package com.connor.leetmedium;


import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0; i< candidates.length; i++){
            List<Integer> path = new ArrayList<>();
            path.add(candidates[i]);
            backtrack(candidates, target-candidates[i], result, path, i);
            path.clear();
        }
        return result;
    }


    private static void backtrack(int[] candidates, int target, List<List<Integer>> results, List<Integer> path, int startIndex) {
        if(target == 0) {
            results.add(new ArrayList<>(path));
            return;
        } else if(target < 0) return; // we've gone too far
        // state check... is this target impossible?

        for(int i = startIndex; i < candidates.length; i++) {
            path.add(candidates[i]);
            backtrack(candidates, target - candidates[i], results, path, i);
            path.remove(path.size()-1);
        }
        // we can check if any of the backtracks had a match here and put it in state
    }
}
