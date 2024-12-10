package com.connor.leeteasy;

public class MinAbsoluteDiffBST {
    public static Integer result;
    public static Integer previous;


    public static int getMinimumDifference(TreeNode root) {
        result = Integer.MAX_VALUE;
        previous = null;
        dfsMinDiff(root);
        return result;
    }

    private static void dfsMinDiff(TreeNode node){
        if(node == null) return;

        dfsMinDiff(node.left);
        if(previous != null)
            result = Math.min(result, node.val - previous);
        previous = node.val;

        dfsMinDiff(node.right);
    }

}
