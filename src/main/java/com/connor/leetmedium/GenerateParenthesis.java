package com.connor.leetmedium;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {

    public static List<String> generateParenthesis(int n) {
        List<String> results = new ArrayList<>();
        generateParenthesisRecursive(n, 0, new StringBuilder(), results);
        return results;
    }

    private static void generateParenthesisRecursive(int opens_available, int closes_available, StringBuilder validPath, List<String> allValidPaths){
        if(opens_available <= 0 && closes_available <= 0) {
           allValidPaths.add(validPath.toString());
           return;
        }

        if(opens_available >= 1) {
            generateParenthesisRecursive( opens_available-1, closes_available+1, validPath.append('('),allValidPaths);
            validPath.deleteCharAt(validPath.length()-1);
        }
        if(closes_available >= 1){
            generateParenthesisRecursive(opens_available, closes_available-1, validPath.append(')'), allValidPaths);
            validPath.deleteCharAt(validPath.length()-1);
        }
    }
}