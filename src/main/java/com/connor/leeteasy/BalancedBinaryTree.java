package com.connor.leeteasy;

public class BalancedBinaryTree {
    public static boolean isBalanced(TreeNode root) {
        return returnDepthOrErrorIfUnbalanced(root, 2) >= 0;
    }

    private static int returnDepthOrErrorIfUnbalanced(TreeNode node, int max_val){
        if(node == null) return 0;

        int left = returnDepthOrErrorIfUnbalanced(node.left, max_val);
        int right = returnDepthOrErrorIfUnbalanced(node.right, max_val);

        int diff = left - right;

        if(Math.abs(diff) >= max_val) return -1000;
        else return 1 + Math.max(left, right);
    }

}
