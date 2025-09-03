package com.connor.leeteasy;

import java.util.concurrent.atomic.AtomicReference;

public class SecondMinNodeInBinaryTree {

    public static int findSecondMinimumValue(TreeNode root) {
        if (root == null) return -1;
        AtomicReference<Integer> min = new AtomicReference<>(null); // of course these could have been class variables too
        AtomicReference<Integer> second_min = new AtomicReference<>(null); // of course these could have been class variables too
        dfs(root, min, second_min);
        return second_min.get() == null ? -1 : second_min.get();
    }

    private static void dfs(TreeNode node, AtomicReference<Integer> min, AtomicReference<Integer> second_min){
        if(node == null) return;

        if(min.get() == null) { // first node!
            min.set(node.val);
        } else if(node.val < min.get()){ // do we have a new global min
            second_min.set(min.get()); // otherwise just shift the old min to second min
            min.set(node.val);
        } else if (second_min.get() == null || node.val < second_min.get()){
            if(node.val != min.get())
                second_min.set(node.val);
        }

        dfs(node.left, min, second_min);
        dfs(node.right, min, second_min);
    }

}
