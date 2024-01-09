package com.connor.leeteasy;

public class SymmetricTree {
    public static boolean isSymmetric(TreeNode root) {
        return areTreesSymmetric(root.left, root.right);
    }

    private static boolean areTreesSymmetric(TreeNode tree1, TreeNode tree2){
        if(tree1 == null && tree2 == null) return true;
        else if((tree1 == null && tree2 != null) || (tree1 != null && tree2 == null)) return false;
        return ((tree1.val == tree2.val) &&
                areTreesSymmetric(tree1.left, tree2.right) && areTreesSymmetric(tree1.right, tree2.left));
    }
}
