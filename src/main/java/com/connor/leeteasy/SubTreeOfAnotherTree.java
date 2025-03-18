package com.connor.leeteasy;

import java.util.ArrayList;
import java.util.List;

public class SubTreeOfAnotherTree {
    private static boolean matchFound;
    public static boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(subRoot == null) return true;
        matchFound = false;
        doesFullTreeContainAnyMatch(root, subRoot);
        return matchFound;
    }

    public static void doesFullTreeContainAnyMatch(TreeNode node, TreeNode subTreeNode){
        if(node == null || matchFound) return;
        if(node.val == subTreeNode.val) matchFound = isTreeMatch(node, subTreeNode);
        doesFullTreeContainAnyMatch(node.left, subTreeNode);
        doesFullTreeContainAnyMatch(node.right, subTreeNode);
    }

    public static boolean isTreeMatch(TreeNode node, TreeNode subTreeNode){
        if(node == null && subTreeNode == null) return true;
        if(node == null || subTreeNode == null) return false;

        if(node.val != subTreeNode.val) return false;
        boolean isMatch = isTreeMatch(node.left, subTreeNode.left);
        isMatch = isMatch && isTreeMatch(node.right, subTreeNode.right);
        return isMatch;
    }

    // ====== using serialisation ========
    public static boolean useSerialisation(TreeNode root, TreeNode subRoot){
        if(subRoot == null) return true;

        matchFound = false;
        String serialisedSubRootList = postOrderList(subRoot, null);
        postOrderList(root, serialisedSubRootList);
        return matchFound;
    }

    public static String postOrderList(TreeNode root, String serialisedSubRootList){
        if(root == null) return "x";

        StringBuilder result = new StringBuilder(); // this means the builder will be on the stack while we process all the subnodes
        result.append(root.val);

        result.append(postOrderList(root.left, serialisedSubRootList));
        result.append(postOrderList(root.right, serialisedSubRootList));

        if(serialisedSubRootList != null && result.length() == serialisedSubRootList.length() && result.toString().equals(serialisedSubRootList)) matchFound = true;
        return result.toString();
    }
}
