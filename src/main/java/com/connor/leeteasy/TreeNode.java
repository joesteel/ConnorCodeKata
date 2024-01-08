package com.connor.leeteasy;

import java.util.Arrays;
import java.util.Iterator;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
    }

    public static TreeNode DeserializeTree (String serialisedTree) {
        /*
        "1 2 4 x x 5 x x 3 x x "
                1
               /  \
              2    3
             / \
            4   5
         */
        Iterator<String> itr = Arrays.stream(serialisedTree.split(" ")).iterator();
        TreeNode tree = createTreeFromStringItr(itr);
        return tree;
    }

    private static TreeNode createTreeFromStringItr(Iterator<String> itr){
        String val = itr.next();
        if(val.equals("x")) return null;

        TreeNode currentNode = new TreeNode(Integer.parseInt(val));
        if(itr.hasNext()) {
            currentNode.left = createTreeFromStringItr(itr);
            currentNode.right = createTreeFromStringItr(itr);
        }
        return currentNode;
    }
}
