package com.connor.leeteasy;

public class InvertBinaryTree {

    public static TreeNode invertTree(TreeNode root) {
        if(root == null) return null;

        TreeNode tempLeft = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(tempLeft);
        return root;
    }
}
