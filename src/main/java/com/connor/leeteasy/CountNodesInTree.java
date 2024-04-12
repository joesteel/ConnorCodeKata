package com.connor.leeteasy;

public class CountNodesInTree {
    public static int countNodes(TreeNode root) {
        return dfs(root);
    }

    private static int dfs(TreeNode root){
        if(root == null) return 0;

        return dfs(root.left) + dfs(root.right) + 1;
    }
}
