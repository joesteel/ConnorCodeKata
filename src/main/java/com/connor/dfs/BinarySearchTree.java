package com.connor.dfs;

import org.omg.CORBA.DynAnyPackage.Invalid;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BinarySearchTree {
    public static final int LIST_CHECK = 0;
    public static final int RANGE_CHECK = 1;

    public static boolean validBst(TreeNode<Integer> root) {
        return validBst(root, LIST_CHECK);
    }

    public static boolean validBst(TreeNode<Integer> root, int type) {
        switch (type) {
            case RANGE_CHECK:
                return validBstUsingRangeCheck(root);
            default:
                return validBstUsingList(root);
        }
    }

    public static boolean validBstUsingList(TreeNode<Integer> root) {
        ArrayList<Integer> list = new ArrayList<>();
        captureOrderedTraversal(root, list);
        return orderedList(list);
    }

    private static boolean orderedList(List<Integer> list) {
        boolean validBst = true;
        Iterator<Integer> itr = list.iterator();
        if (itr.hasNext()) {
            Integer current, previous = itr.next();
            while (itr.hasNext()) {
                current = itr.next();
                if (previous.compareTo(current) > 0) validBst = false;
                previous = current;
            }
        }
        return validBst;
    }

    public static void captureOrderedTraversal(TreeNode<Integer> node, List<Integer> list) {
        if (node != null) {
            captureOrderedTraversal(node.left, list);
            list.add(node.val);
            captureOrderedTraversal(node.right, list);
        }
    }

    public static boolean validBstUsingRangeCheck(TreeNode<Integer> root) {
        return validRangeForEachNodeOfTree(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public static boolean validRangeForEachNodeOfTree(TreeNode<Integer> node, int minValue, int maxValue) {
        if (node == null) return true;
        if (node.val < minValue || node.val > maxValue) return false;
        return (validRangeForEachNodeOfTree(node.left, minValue, node.val) && validRangeForEachNodeOfTree(node.right, node.val, maxValue));
    }


    public static TreeNode<Integer> insertBst(TreeNode<Integer> bst, int val) {
        if (bst == null) return new TreeNode<Integer>(val);
        if (val < bst.val) bst.left = insertBst(bst.left, val);
        else if (val > bst.val) bst.right = insertBst(bst.right, val);
        return bst;
    }


    public static TreeNode<Integer> invertBinaryTree(TreeNode<Integer> tree) {
        // go left and swap kids
        // go right and swap kids
        // swap my kids
        swapNodes(tree);
        return tree;
    }

    public static void swapNodes(TreeNode<Integer> node){
        if(node == null) return;
        swapNodes(node.left);
        swapNodes(node.right);
        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;
    }

    public static TreeNode<Integer> buildInvertedCopy(TreeNode<Integer> node) {
        return null;
    }


    public static int lcaOnBst(TreeNode<Integer> bst, int p, int q) {
        // WRITE YOUR BRILLIANT CODE HERE
        if(p == q) return p;
        return findAncestor(bst, Math.min(p, q), Math.max(p,q));
    }

    public static int findAncestor(TreeNode<Integer> node, int smallerChild, int largerChild) throws IllegalArgumentException {
        // WRITE YOUR BRILLIANT CODE HERE
        if(node == null) throw new IllegalArgumentException("child nodes do not exist in tree"); // this shouldn't happen
        if(node.val >= smallerChild && node.val <= largerChild) return node.val;
        else if (node.val > smallerChild && node.val > largerChild) return findAncestor(node.left, smallerChild, largerChild);
        else return findAncestor(node.right, smallerChild, largerChild);
    }


}
