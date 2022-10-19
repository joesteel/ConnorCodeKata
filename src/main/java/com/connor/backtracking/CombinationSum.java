package com.connor.backtracking;

import java.util.*;

public class CombinationSum {
    public static List<List<Integer>> combinationSum(List<Integer> candidates, int target) {
        // WRITE YOUR BRILLIANT CODE HERE
        return combinationSum(candidates, target, "default");
    }


    public static List<List<Integer>> combinationSum(List<Integer> candidates, int target, String type) {

        switch (type){
            case "dupes":
                List<List<Integer>> result = new ArrayList<>();
                dfs(target, candidates, 0, 0, result, new ArrayList<>());
                return result;
            default:
                return dfs(0, candidates, target, new ArrayList<>());

        }
    }

    public static List<List<Integer>> dfs(int currentSum, List<Integer> candidates, int target, List<Integer> path){
        if(currentSum == target){
            List<Integer> pathSnapshot = new ArrayList<>(path);
            Collections.sort(pathSnapshot);
            List<List<Integer>> allPaths = new ArrayList<>();
            allPaths.add(pathSnapshot);
            return allPaths;
        }


        List<List<Integer>> allPathsToTargetFromHere = new ArrayList<>();
        for(int candidate:candidates){
            // for each candidate add the candidate to the currentSum and go down the tree
            if(candidate+currentSum <= target){
                path.add(candidate);
                List<List<Integer>> subTreeResults = dfs(currentSum+candidate, candidates, target, path);
                if(subTreeResults.size() > 0){
                    // then parse the results from the branches and merge them into my
                    for(List<Integer> result: subTreeResults){
                        if(!allPathsToTargetFromHere.contains(result)) allPathsToTargetFromHere.add(result);
                    }
                }
                path.remove(path.size()-1);
            }
        }
        return allPathsToTargetFromHere;
    }


    public static void dfs(int target,  List<Integer> candidates,  int startIndex, int previousIndex, List<List<Integer>> paths, List<Integer> path){
        if(startIndex == target){
            paths.add(new ArrayList<>(path));
            return;
        }
        for(int i = previousIndex; i< candidates.size(); i++){
            path.add(candidates.get(i));
            if(startIndex+candidates.get(i) <= target) {
                dfs(target, candidates, startIndex + candidates.get(i), i , paths, path);
            }
            path.remove(path.size()-1);
        }
    }


}
