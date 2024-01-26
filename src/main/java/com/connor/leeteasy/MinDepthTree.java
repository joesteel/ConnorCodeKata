package com.connor.leeteasy;

public class MinDepthTree {

    public static int minDepth(TreeNode root) {
        return dfs(root);
    }


    private static int dfs(TreeNode node) {
        if(node == null) return Integer.MAX_VALUE;

        if(node.left == null && node.right == null) return 1;
        else return 1 + Math.min(dfs(node.left), dfs(node.right));
    }
}
