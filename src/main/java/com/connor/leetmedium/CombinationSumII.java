package com.connor.leetmedium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates); // sort so we can exit early
        ArrayList<List<Integer>> result = new ArrayList<>(); // is there a better way to do this without a set?
        backtrack(candidates, target, result, new ArrayList<>(), 0);
        return result;
    }


    private static void backtrack(int[] candidates, int target, ArrayList<List<Integer>> results, List<Integer> path, int startIndex) {
        if(target == 0) {
            results.add(new ArrayList<>(path));
            return;
        }
        if(target < 0) return;

        for(int i = startIndex; i < candidates.length && target - candidates[i] >= 0; i++) {
            if(i > startIndex && candidates[i] == candidates[i-1]) continue; // need a better way to skip duplicates
            path.add(candidates[i]);
            backtrack(candidates, target - candidates[i], results, path, i + 1);
            path.remove(path.size() - 1);
        }
    }
}
