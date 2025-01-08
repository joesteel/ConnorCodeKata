package com.connor.leeteasy;

public class BTreeDiameter {

    // I think we nee to, find the max depth of each sub tree...
    // then add those together to compare against a global variable where we keep the max
    private static int MaxDiameter;
    public static int diameterOfBinaryTree(TreeNode root) {
        MaxDiameter = 0;
        dfs(root);
        return MaxDiameter;
    }

    private static int dfs(TreeNode node){
        if(node == null) return 0;

        int left_depth = dfs(node.left);
        int right_depth = dfs(node.right);

        int diameter_of_subtree = left_depth+right_depth;
        MaxDiameter = Math.max(diameter_of_subtree, MaxDiameter);

        return Math.max(left_depth, right_depth) + 1;
    }
}
