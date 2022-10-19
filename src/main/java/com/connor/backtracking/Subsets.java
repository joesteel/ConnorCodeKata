package com.connor.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

    public static List<List<Integer>> subsets(List<Integer> nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        dfs(0, nums, new ArrayList<>(), subsets);
        return subsets;
    }

    public static void dfs(int startIndex, List<Integer> nums, List<Integer> path, List<List<Integer>> subsets){
        if(startIndex == nums.size()){
            return;
        }
        for(int i = startIndex; i<nums.size(); i++){
            path.add(nums.get(i));
            dfs(i+1, nums, path, subsets);
            subsets.add(new ArrayList<>(path));
            path.remove(path.size()-1);
        }
    }

}
