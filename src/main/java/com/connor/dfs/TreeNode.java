package com.connor.dfs;

public class TreeNode<T> {
    public TreeNode left;
    public TreeNode right;
    public T val;

    public TreeNode(T value){
        this(value, null, null);
    }

    public TreeNode(T value, TreeNode leftNode, TreeNode rightNode){
        val = value;
        left = leftNode;
        right = rightNode;
    }
}
