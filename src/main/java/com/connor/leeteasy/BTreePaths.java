package com.connor.leeteasy;

import java.util.ArrayList;
import java.util.List;

public class BTreePaths {

    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<String>();
        dfs(root, paths, "");
        return paths;
    }

    private static void dfs(TreeNode node, List<String> paths, String path){
        if(node == null) return;

        path = path + node.val;
        if(node.left == null && node.right == null) {
            paths.add(path);
        }
        path = path + "->";
        dfs(node.left, paths, path);
        dfs(node.right, paths, path);
    }
}
