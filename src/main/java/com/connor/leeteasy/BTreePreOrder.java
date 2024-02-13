package com.connor.leeteasy;

import java.util.ArrayList;
import java.util.List;

public class BTreePreOrder {

    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> preOrderTraversalPath = new ArrayList<>();
        dfsPreOrder(root, preOrderTraversalPath);
        return preOrderTraversalPath;
    }

    private static void dfsPreOrder(TreeNode node, List<Integer> list){
        if(node == null) return;

        list.add(node.val);
        dfsPreOrder(node.left, list);
        dfsPreOrder(node.right, list);
    }
}
