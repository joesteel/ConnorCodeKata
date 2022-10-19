package com.connor.backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Permutations {

    public static List<String> permutations(String letters) {
        List<String> results = new ArrayList<>();
        dfs(letters, new ArrayList<>(), results);
        return results;
    }

    public static void dfs(String letters, List<Character> path, List<String> results){
        if(path.size() >= letters.length()){
            results.add(path.stream()
                    .map(e -> e.toString())
                    .collect(Collectors.joining()));
            return;
        }
        for(char c: letters.toCharArray()){
            if(!path.contains(c)){
                path.add(c);
                dfs(letters, path, results);
                path.remove(path.size()-1);
            }
        }
    }
}