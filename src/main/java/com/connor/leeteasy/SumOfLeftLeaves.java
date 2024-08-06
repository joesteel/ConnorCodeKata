package com.connor.leeteasy;

public class SumOfLeftLeaves {

    public static int sumOfLeftLeaves(TreeNode root) {
        return dfs(root, false);
    }

    private static int dfs(TreeNode node, boolean isLeft){
        if(node == null) return 0;

        int result = 0;
        if(isLeft && node.left == null && node.right == null) result += node.val;

        result += dfs(node.left, true);
        result += dfs(node.right, false);
        return  result;
    }
}
