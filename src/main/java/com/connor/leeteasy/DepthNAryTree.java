package com.connor.leeteasy;

import java.util.List;

public class DepthNAryTree {
    private static class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }
        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };

    public int maxDepth(Node root) {
        return dfsMaxDepth(root);
    }

    private int dfsMaxDepth(Node node){
        if(node == null) return 0;

        int maxDepthOfChildren = 0;
        for(Node child: node.children){
            int maxDepthOfChild = dfsMaxDepth(child);
            maxDepthOfChildren = Math.max(maxDepthOfChildren,maxDepthOfChild);
        }
        return maxDepthOfChildren + 1;
     }
}
