package com.connor.leeteasy;

public class MergeTrees {

    public static TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        return dfsMerge(root1, root2);
    }

    public static TreeNode dfsMerge(TreeNode root1, TreeNode root2){
        if(root1 == null && root2 == null) return null;
        if(root1 == null || root2 == null) return root1 == null ? root2 : root1;

        TreeNode node = new TreeNode(root1.val + root2.val);
        node.left = dfsMerge(root1.left, root2.left);
        node.right = dfsMerge(root1.right, root2.right);

        return node;
    }
}
