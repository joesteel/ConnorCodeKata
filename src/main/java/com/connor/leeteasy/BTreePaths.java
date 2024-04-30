package com.connor.leeteasy;

import java.util.ArrayList;
import java.util.List;

public class BTreePaths {

    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<String>();
        dfs(root, paths, new ArrayList<>());
        return paths;
    }

    private static void dfs(TreeNode node, List<String> paths, List<Integer> path){
        if(node == null) return;

        path.add(node.val);
        if(node.left == null && node.right == null) {
            paths.add(pathToString(path));
        }

        dfs(node.left, paths, path);
        dfs(node.right, paths, path);
        path.removeLast();
    }

    private static String pathToString(List<Integer> path){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < path.size(); i++){
            sb.append(path.get(i));
            if(i < path.size() -1) sb.append("->");
        }
        return sb.toString();
    }
}
