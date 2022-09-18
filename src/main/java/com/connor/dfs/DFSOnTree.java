package com.connor.dfs;

public class DFSOnTree {

    public static int treeMaxDepth(final TreeNode<Integer> root) {
        return maxDepthUp(root);
    }
    public static int maxDepthDown(final TreeNode<Integer> node, final int parentDepth){
        if (node == null) return parentDepth;
        int myDepth = parentDepth+1;
        return Math.max(maxDepthDown(node.left, myDepth),maxDepthDown(node.right, myDepth));
    }

    public static int maxDepthUp(final TreeNode<Integer> node){
        if (node == null) return 0;
        return Math.max(maxDepthUp(node.left),maxDepthUp(node.right)) + 1;
    }

    public static int visibleTreeNode(TreeNode<Integer> root) {
        return visibleTreeNode(root, Integer.MIN_VALUE);
    }

    public static int visibleTreeNode(TreeNode<Integer> node, int maxOnRouteToNode) {
        if(node == null) return 0;
        int nodeVisible = 0;
        if(node.val >= maxOnRouteToNode) {
            maxOnRouteToNode = node.val;
            nodeVisible = 1;
        }
        return visibleTreeNode(node.left, maxOnRouteToNode) + visibleTreeNode(node.right, maxOnRouteToNode) + nodeVisible;
    }
}

