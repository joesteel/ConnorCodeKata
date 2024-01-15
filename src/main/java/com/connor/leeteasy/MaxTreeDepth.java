package com.connor.leeteasy;

public class MaxTreeDepth {

    public static int maxDepth(TreeNode root) {
        return dfs(root);
    }

    private static int dfs(TreeNode node) {
        if(node == null) return 0;
        return 1 + Math.max(dfs(node.left), dfs(node.right));
    }
}
