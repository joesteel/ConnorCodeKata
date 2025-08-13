package com.connor.leeteasy;

import java.util.HashMap;
import java.util.HashSet;

public class TwoSumBST {
    public boolean findTargetSet(TreeNode root, int k) {
        HashSet<Integer> set = new HashSet<>();
        return dfs(root, k, set);
    }

    private static boolean dfs(TreeNode node, int k, HashSet<Integer> set){
        if(node == null) return false;

        if(set.contains(k-node.val)) return true;
        else set.add(node.val);

        return dfs(node.left,  k, set) ||  dfs(node.right,  k, set);
    }
}
