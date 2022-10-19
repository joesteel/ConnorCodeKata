package com.connor.backtracking;


import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class LetterCombination {

    public static List<String> letterCombination(int n) {
        List<String> letterCombinations = new ArrayList<>();
        List<String> path = new ArrayList<>();
        dfs(0, n, letterCombinations, path);
        return letterCombinations;
    }

    public static void dfs(int layer, int maxLayer, List<String> letterCombinations, List<String> path){
        if(layer == maxLayer){ // I'm a leaf
            letterCombinations.add(String.join("", path));
            return;
        }
        // traverse some edges
        String edges = "a b";
        for (String edge : edges.split(" ")) {
            path.add(edge);
            dfs(layer+1, maxLayer, letterCombinations, path);
            path.remove(path.size()-1);
        }
    }

}
