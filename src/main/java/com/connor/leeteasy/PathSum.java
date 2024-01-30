package com.connor.leeteasy;

public class PathSum {
    public static boolean hasPathSum(TreeNode root, int targetSum) {
        return dfs(root, targetSum, 0);
    }

    private static boolean dfs(TreeNode node, int target, int pathSum){
        if (node == null) return false;

        pathSum += node.val;
        if(node.left == null && node.right == null) return pathSum == target;

        return (dfs(node.left, target, pathSum)) || dfs(node.right, target, pathSum);
    }
}
