package com.connor.leeteasy;
import java.util.ArrayList;
import java.util.List;


public class BTreePostOrder {
    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        dfsPostOrder(root, result);
        return result;
    }

    private static void dfsPostOrder(TreeNode node, List<Integer> path) {
        if(node == null) return;

        dfsPostOrder(node.left, path);
        dfsPostOrder(node.right, path);
        path.add(node.val);
    }
}
