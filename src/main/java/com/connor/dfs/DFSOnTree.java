package com.connor.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class DFSOnTree {
    public static int treeMaxDepth(final TreeNode<Integer> root) { return treeMaxDepth(root, 0);}

    public static int treeMaxDepth(final TreeNode<Integer> root, int type) {
        switch (type){
            case 1:
                return maxDepthUp(root);
            default:
                return maxDepthDown(root, 0);
        }
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

    public static boolean isBalanced(TreeNode<Integer> root) {
        return depthIfChildrenAreBalanced(root) >= 0;
    }

    private static int depthIfChildrenAreBalanced(TreeNode<Integer> node){
        // return max depth if balanced, return -1 if tree unbalanced
        if(node == null) return 0;
        int leftDepth = depthIfChildrenAreBalanced(node.left);
        if(leftDepth < 0) return -1;
        int rightDepth = depthIfChildrenAreBalanced(node.right);
        if(rightDepth < 0 || Math.abs(leftDepth - rightDepth) > 1) return -1;
        else return Math.max(leftDepth, rightDepth) + 1;
    }

    public static String serialize(TreeNode root) {
        // myself, then left, then right - pre-order
        // for a nulls value add an x, followed by a space to the stringBuilder
        // otherwise add the int value, followed by a space and pass it back
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();
    }

    public static void serialize(TreeNode node, StringBuilder sb) {
        if(sb.length() > 0) sb.append(" ");
        if(node == null) {
            sb.append("x");
        } else {
            sb.append(node.val);
            serialize(node.left, sb);
            serialize(node.right, sb);
        }
    }

    public static TreeNode<Integer> deserialize(String root) {
        ArrayList<String> nodeList = new ArrayList<>(Arrays.asList(root.split(" ")));
        Iterator<String> iter = nodeList.iterator();
        return deserialize(iter);
    }

    public static TreeNode<Integer> deserialize(Iterator<String> nodeItr) {
        TreeNode<Integer> node = null;
        if(nodeItr.hasNext()){
            String nodeVal = nodeItr.next();
            if(!nodeVal.equals("x")){
                node = new TreeNode<Integer>(Integer.parseInt(nodeVal));
                node.left = deserialize(nodeItr);
                node.right = deserialize(nodeItr);
            }
        }
        return node;
    }

    public static TreeNode<Integer>  lca(TreeNode<Integer>  root, TreeNode<Integer>  node1, TreeNode<Integer>  node2) {
        // option 1 : traverse to the node and save the journey in a list, same for node 2...
        // the first point where the lists don't match is where their ancestry diverges
        return lca(root, node1, node2, 0);
    }

    public static TreeNode<Integer>  lca(TreeNode<Integer>  root, TreeNode<Integer>  node1, TreeNode<Integer>  node2, int type) {
       switch (type) {
           case 1:
               return lcaUsingChildKnowledge(root, node1, node2);
           default:
               return lcaUsingPath(root, node1, node2);
       }
    }

    public static TreeNode<Integer> lcaUsingChildKnowledge(TreeNode<Integer>  root, TreeNode<Integer>  node1, TreeNode<Integer>  node2){
        if(root == null) return null;
        if(root.equals(node1) || root.equals(node2)) return root; // I'm either lca or one of the nodes
        TreeNode<Integer> leftResult = lcaUsingChildKnowledge(root.left, node1, node2);
        TreeNode<Integer> rightResult = lcaUsingChildKnowledge(root.right, node1, node2);
        if(leftResult != null && rightResult != null) return root; // I'm the lca!
        else if(leftResult != null) return leftResult; // one of my left children is a node (my right returned nothing)
        else if (rightResult != null) return rightResult; // one of my right children is a node (my left returned nothing)
        else return null; // no matches at all
    }

    public static TreeNode<Integer>  lcaUsingPath(TreeNode<Integer>  root, TreeNode<Integer>  node1, TreeNode<Integer>  node2) {
        List<TreeNode<Integer>> pathToNode1 = new ArrayList<>(), pathToNode2 = new ArrayList<>();
        findPathToNode(root, node1, pathToNode1);
        findPathToNode(root, node2, pathToNode2);
        int shortestPath = Math.min(pathToNode1.size(), pathToNode2.size());
        if(shortestPath == 0) return null;
        else{
            int i = 0;
            for(; i < shortestPath; i++){
                if(!pathToNode1.get(i).equals(pathToNode2.get(i))) break;
            }
            return pathToNode1.get(i-1);
        }
    }

    public static boolean findPathToNode(TreeNode<Integer>  node, TreeNode<Integer>  nodeToFind, List<TreeNode<Integer>> listToPopulate){
        if(node == null) return false;
        else if(node.equals(nodeToFind)){
            listToPopulate.add(node);
            return true;
        }
        else {
            listToPopulate.add(node);
            if(findPathToNode(node.left, nodeToFind, listToPopulate) == false && findPathToNode(node.right, nodeToFind, listToPopulate) == false) {
                listToPopulate.remove(listToPopulate.size() - 1);
                return false;
            }
            else return true;
        }
    }

}


