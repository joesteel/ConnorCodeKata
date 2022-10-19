package com.connor.backtracking;

import java.util.ArrayList;
import java.util.List;

public class ValidParenthesis {

    public static List<String> generateParentheses(int n) {
        return generateParentheses(n, "");
    }

    public static List<String> generateParentheses(int n, String type) {
        List<String> paths = new ArrayList<>();
        if(type == "easy"){
            dfs(n, new StringBuilder(), paths, 0,0);
        } else connorDfs(n*2, 0, new StringBuilder(), paths);
        return paths;
    }

    public static void dfs(int n, StringBuilder path, List<String> paths, int openCount, int closeCount ) {
        if (path.length() == n * 2) {
            paths.add(path.toString());
            return;
        }
        if (openCount < n) {
            path.append('(');
            dfs(n, path, paths, openCount+1, closeCount);
            path.deleteCharAt(path.length()-1);
        }
        if (closeCount < openCount) {
            path.append(')');
            dfs(n, path, paths, openCount, closeCount+1);
            path.deleteCharAt(path.length()-1);
        }
    }
    public static void connorDfs(int maxHeight, int height, StringBuilder path, List<String> paths){
        if(height == maxHeight && isValidParenthesisStream(path.toString(), true)){
            paths.add(path.toString());
            return;
        }
        for(char c:new char[]{'(',')'}){
            path.append(c);
            if(isValidParenthesisStream(path.toString()) && hasEnoughSpaceToCompletePattern(path.toString(), maxHeight-height)){
                connorDfs(maxHeight, height+1, path, paths);
            }
            path.deleteCharAt(path.length()-1);
        }
    }

    public static boolean isValidParenthesisStream(String parentheses){
        return isValidParenthesisStream(parentheses, false);
    }

    public static boolean isValidParenthesisStream(String parentheses, boolean checkComplete){
        char[] parenthesisStream = parentheses.toCharArray();
        List<Character> stack = new ArrayList<>();
        for(char c:parenthesisStream){
            if(c == '('){
                stack.add(c);
            }
            else if (c == ')'){
                char topOfStack = 'X';
                if(stack.size() > 0){
                    topOfStack = stack.remove(stack.size()-1);
                }
                if(topOfStack != '(') return false;
            }
            else continue;
        }
        if(checkComplete){
            return stack.size() == 0;
        }
        else return true;
    }

    public static boolean hasEnoughSpaceToCompletePattern(String parentheses, int remainingChars){
        char[] parenthesisStream = parentheses.toCharArray();
        int leftCount = 0, rightCount = 0;
        for(char c:parenthesisStream){
            if(c == '(') leftCount++;
            if(c == ')') rightCount++;
        }
        return(remainingChars >= Math.abs(leftCount-rightCount));
    }
}
